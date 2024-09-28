package com.example.thundertech;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class PostController implements Initializable {

    @FXML
    private Text post_type;


    @FXML
    private DatePicker expt_date;

    @FXML
    private TextArea description;

    @FXML
    private TextField title;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int typeNumber = DashboardController.domain;
        switch (typeNumber){
            case 1:
                post_type.setText("Python Development");
                break;
            case 2:
                post_type.setText("FrontEnd Development");
                break;
            case 3:
                post_type.setText("JavaScript Development");
                break;
            case 4:
                post_type.setText("Android Development");
                break;
            case 5:
                post_type.setText("IOS Development");
                break;
            case 6:
                post_type.setText("Machine Learning Development");
                break;
            case 7:
                post_type.setText("Deep Learning Development");
                break;
            case 8:
                post_type.setText("Backend Development");
                break;
            case 9:
                post_type.setText("Database Design Development");
                break;
            case 10:
                post_type.setText("Ai Development");
                break;
        }
    }

    @FXML
    void post_to_dashboard(ActionEvent event) {
        DashboardController.domain = 0;
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


    @FXML
    void post(ActionEvent event) {
        System.out.println(1);
        String title_str = title.getText();
        String description_str = description.getText();
        LocalDate expt_date_rcv = expt_date.getValue();

        boolean flag = true;

        if(title_str.isEmpty()){
            System.out.println(2);
            flag = false;
        }

        if(description_str.isEmpty()){
            System.out.println(3);
            flag = false;
        }

        if(LoginController.user.isEmpty()) {
            System.out.println(4);
            flag = false;
        }

        if(flag){
            System.out.println(5);
            String sql = "insert into post(username,domain,title,details,expt_date) values (?,?,?,?,?)";
            final String URL = "jdbc:mysql://localhost:3306/thundertech";
            final String USER = "root";
            final String PASSWORD = "";


            try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement pst = con.prepareStatement(sql)) {
                System.out.println(6);

                // Set parameters
                pst.setString(1, LoginController.user);
                pst.setString(2, DashboardController.domain + "");
                pst.setString(3, title_str);
                pst.setString(4, description_str);
                pst.setString(5, expt_date_rcv.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

                // Execute the SQL INSERT statement
                int row = pst.executeUpdate();

                if(row > 0){
                    System.out.println(7);
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
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }






}
