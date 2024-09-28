package com.example.thundertech;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.ResourceBundle;
import java.net.URL;

public class LoginController implements Initializable {

    static String user = "";

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    void direct_admin(MouseEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    @FXML
    void login_btn(ActionEvent event) {
        String username_str = username.getText();
        String password_str = password.getText();


        boolean flag = true;
        if (username_str.isEmpty()) {
            flag = false;
        }

        if (password_str.isEmpty()) {
            flag = false;
        }

        String sql = "select password from user where username = '" + username_str + "'";
        final String URL = "jdbc:mysql://localhost:3306/thundertech";
        final String USER = "root";
        final String PASSWORD = "";


        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();

            String pass = rs.getString(1);


            if (pass == null || pass.isEmpty()) {
                return;
            }

            if (pass.equals(password_str)) {

                user = username_str;

                Parent parent = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

                Scene scene2 = new Scene(parent);

                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setTitle("Dashboard");

                window.setScene(scene2);
                window.show();
            } else {
                System.out.println("Login Error");
            }
            con.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void signup_btn(ActionEvent event) throws IOException {
            Parent parent = FXMLLoader.load(getClass().getResource("signup.fxml"));

            Scene scene2 = new Scene(parent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Sign Up");

            window.setScene(scene2);
            window.show();
    }


}



