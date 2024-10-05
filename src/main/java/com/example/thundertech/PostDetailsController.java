package com.example.thundertech;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.*;
import java.time.format.DateTimeFormatter;

public class PostDetailsController {
    static String post_owner = "";
    @FXML
    private Text cost_txt;
    @FXML
    private Text des_txt;
    @FXML
    private Text domain_txt;


    @FXML
    private Text header_txt;

    @FXML
    public void initialize() {
//        header_txt.setText(Prev_WorkController.stat_post_no + "");
        String sql = "SELECT domain, title, details, expt_date, expt_cost, post_no,username FROM post WHERE post_no = ?";
        final String URL = "jdbc:mysql://localhost:3306/thundertech";
        final String USER = "root";
        final String PASSWORD = "";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(sql)) {

            // Set the post number parameter for the SQL query
            pst.setString(1, Prev_WorkController.stat_post_no + "");

            // Execute the query
            ResultSet resultSet = pst.executeQuery();

            // Process the result set
            while (resultSet.next()) {
                String heading = resultSet.getString("title");
                String domainStr = resultSet.getString("domain");  // corrected the typo
                String cost = resultSet.getString("expt_cost");
                String context = resultSet.getString("details");
                String username = resultSet.getString("username");

                post_owner = username;

                // Update UI elements
                System.out.println(heading);
                header_txt.setText(heading);  // Ensure header_txt is initialized
                des_txt.setText(context);     // Ensure des_txt is initialized
                cost_txt.setText(cost+"$");       // Ensure cost_txt is initialized

                // Parse domain value and map it to a domain name
                String domName = "";
                try {
                    int domainInt = Integer.parseInt(domainStr);  // Safely parse domain to int
                    switch (domainInt) {
                        case 1:  domName = "Python"; break;
                        case 2:  domName = "Html/Css"; break;
                        case 3:  domName = "Javascript"; break;
                        case 4:  domName = "Android"; break;
                        case 5:  domName = "IOS"; break;
                        case 6:  domName = "ML"; break;
                        case 7:  domName = "Deep Learning"; break;
                        case 8:  domName = "Web Dev"; break;
                        case 9:  domName = "Dbms"; break;
                        case 10: domName = "Ai Dev"; break;
                        default: domName = "Unknown Domain"; break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing domain: " + domainStr);
                }

                domain_txt.setText(domName);  // Ensure domain_txt is initialized

                // Log values to console
                System.out.println(domainStr);
                System.out.println(cost);
                System.out.println(context);
            }

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public void profile_page(javafx.event.ActionEvent actionEvent) {
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource("profile.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scene scene2 = new Scene(parent);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Sign Up");

        window.setScene(scene2);
        window.show();
    }



    public void details_to_dash(javafx.event.ActionEvent actionEvent) {
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scene scene2 = new Scene(parent);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Sign Up");

        window.setScene(scene2);
        window.show();
    }

    public void details_to_chat(javafx.event.ActionEvent actionEvent) {
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource("chat.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scene scene2 = new Scene(parent);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Sign Up");

        window.setScene(scene2);
        window.show();
    }

    public void details_to_work(javafx.event.ActionEvent actionEvent) {
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource("prev_work.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scene scene2 = new Scene(parent);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Sign Up");

        window.setScene(scene2);
        window.show();
    }
}
