package com.example.thundertech;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class SignupController {

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private TextField phone;

    @FXML
    private TextField username;

    @FXML
    void signup(ActionEvent event) {
        String usernameS = username.getText();
        String passwordS = password.getText();
        String emailS = email.getText();
        String phoneS = phone.getText();


        boolean flag = true;
        if (usernameS.isEmpty()) {
            flag = false;
        } else {


            String sql = "SELECT COUNT(*) FROM client WHERE username = '" + usernameS + "'";
            final String URL = "jdbc:mysql://localhost:3306/thundertech";
            final String USER = "root";
            final String PASSWORD = "";


            try {
                Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                rs.next();

                String userCount = rs.getString(1);

                if (Integer.parseInt(userCount) >= 1) {
                    flag = false;
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        if (passwordS.isEmpty()) {

            flag = false;
        }

        if (emailS.isEmpty()) {
            flag = false;
        } else {

            String sql = "SELECT COUNT(*) FROM client WHERE email = '" + emailS + "'";
            final String URL = "jdbc:mysql://localhost:3306/thundertech";
            final String USER = "root";
            final String PASSWORD = "";


            try {
                Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                rs.next();

                String userCount = rs.getString(1);

                if (Integer.parseInt(userCount) >= 1) {
                    flag = false;
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        if (phoneS.isEmpty()) {
            flag = false;
        }


        if (flag) {
            String sql = "INSERT INTO user(username, password, email, phone) VALUES (?, ?, ?, ?)";
            final String URL = "jdbc:mysql://localhost:3306/thundertech";
            final String USER = "root";
            final String PASSWORD = "";

            try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement pst = con.prepareStatement(sql)) {

                // Set parameters
                pst.setString(1, usernameS);
                pst.setString(2, passwordS);
                pst.setString(3, emailS);
                pst.setString(4, phoneS);

                // Execute the SQL INSERT statement
                int row = pst.executeUpdate();

                if (row > 0) {
                    Parent parent = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

                    Scene scene2 = new Scene(parent);

                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setTitle("Dashboard");

                    window.setScene(scene2);
                    window.show();
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
                ;
            }
        }
    }


    @FXML
    void signup_to_login(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("login.fxml"));

        Scene scene2 = new Scene(parent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Sign Up");

        window.setScene(scene2);
        window.show();
    }

}
