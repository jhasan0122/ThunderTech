package com.example.thundertech;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class Prev_WorkController {

    static int stat_post_no =0;

    @FXML
    private GridPane gridList;

    @FXML
    public void initialize() {
        // This code will run when the FXML file is loaded
        System.out.println("Page has been initialized!");
        System.out.println();

        String sql = "SELECT domain,title,details,expt_date,expt_cost,post_no FROM post";
        final String URL = "jdbc:mysql://localhost:3306/thundertech";
        final String USER = "root";
        final String PASSWORD = "";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(sql)) {

            ResultSet resultSet = pst.executeQuery();

            int i=0,j=0;
            while (resultSet.next()){
                if(j>=4){
                    i++;
                    j=0;
                    if(i>=3){
                        break;
                    }
                }

                String ans = resultSet.getString("domain");

                String domName = "";
                switch (Integer.parseInt(ans)){
                    case 1:
                        domName = "Python";
                        break;
                    case 2:
                        domName = "Html/Css";
                        break;
                    case 3:
                        domName = "Javascript";
                        break;
                    case 4:
                        domName = "Android";
                        break;
                    case 5:
                        domName = "IOS";
                        break;
                    case 6:
                        domName = "ML";
                        break;
                    case 7:
                        domName = "Deep Learning";
                        break;
                    case 8:
                        domName = "Web Dev";
                        break;
                    case 9:
                        domName = "Dbms";
                        break;
                    case 10:
                        domName = "Ai Dev";
                        break;
                }


                String heading = resultSet.getString("title");

                String about = domName +" - " +resultSet.getString("expt_cost")+ "$";
                String context = resultSet.getString("details");
                int post_number = Integer.parseInt(resultSet.getString("post_no"));

                Button div = createInvisibleButtonWithPane(heading,about,context,post_number);
                gridList.add(div,j,i);
                j++;
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }


    public Button createInvisibleButtonWithPane(String headerText, String field1, String field2,int post_number) {
        // Create the main container (Pane)
        Pane pane = new Pane();
        pane.setPrefSize(300, 300);
        pane.setStyle("-fx-background-color: #E3F2FD; -fx-background-radius: 10px; -fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.2), 10, 0, 0, 5); -fx-padding: 20;");

        // Create a VBox to arrange elements vertically
        VBox container = new VBox(15);  // Spacing between elements
        container.setPadding(new Insets(20));

        // Create the header
        Text header = new Text(headerText);
        header.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        header.setFill(Color.DARKBLUE);

        // Create the two data fields
        HBox fieldBox1 = createDataField("", field1);
        HBox fieldBox2 = createDataField("", field2);

        // Add the header and fields to the VBox
        container.getChildren().addAll(header, fieldBox1, fieldBox2);

        // Add the VBox to the Pane
        pane.getChildren().add(container);

        // Set the position of the VBox within the Pane
        container.setLayoutX(20);
        container.setLayoutY(20);

        // Create the invisible button
        Button invisibleButton = new Button();
        invisibleButton.setGraphic(pane);  // Add the Pane as the button's graphic
        invisibleButton.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");

        // Remove any button-specific styling like focus ring and padding
        invisibleButton.setFocusTraversable(false);  // Prevents focus ring from showing
        invisibleButton.setPadding(Insets.EMPTY);  // Removes padding inside the button
        invisibleButton.setPrefSize(300, 300);  // Ensure the button is the same size as the pane

        // Add an action handler for the button
        invisibleButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stat_post_no = post_number;
                // Define what happens when the button is clicked
                System.out.println("Button clicked! Pane with header: " + headerText);
                Parent parent = null;
                try {
                    parent = FXMLLoader.load(getClass().getResource("post_details.fxml"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                Scene scene2 = new Scene(parent);

                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setTitle("Sign Up");

                window.setScene(scene2);
                window.show();
            }
        });

        return invisibleButton;
    }

    // Helper function to create a styled HBox for each data field
    private HBox createDataField(String labelText, String valueText) {
        // Create an HBox to hold the label and value
        HBox fieldContainer = new HBox(10);  // Spacing between label and value
        fieldContainer.setPadding(new Insets(10));
        fieldContainer.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #BBDEFB; -fx-border-radius: 5px; -fx-background-radius: 5px;");

        // Create label text
        Text label = new Text(labelText);
        label.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 16));
        label.setFill(Color.BLACK);

        // Create value text
        Text value = new Text(valueText);
        value.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        value.setFill(Color.DIMGRAY);

        // Add the label and value to the HBox
        fieldContainer.getChildren().addAll(label, value);

        return fieldContainer;
    }




    @FXML
    void dashboard_go(ActionEvent event) {
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scene scene2 = new Scene(parent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Sign Up");

        window.setScene(scene2);
        window.show();
    }


}
