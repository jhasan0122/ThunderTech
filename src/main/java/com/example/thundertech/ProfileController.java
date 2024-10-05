package com.example.thundertech;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class ProfileController {
    @FXML
    private Text email_txt;

    @FXML
    private Text phone_txt;

    @FXML
    private Text username_txt;

    @FXML
    public void initialize() {
        String sql = "SELECT email,phone FROM user WHERE username = ?";
        final String URL = "jdbc:mysql://localhost:3306/thundertech";
        final String USER = "root";
        final String PASSWORD = "";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(sql)) {

            // Set the post number parameter for the SQL query
            pst.setString(1, PostDetailsController.post_owner + "");

            // Execute the query
            ResultSet resultSet = pst.executeQuery();

            // Process the result set
            while (resultSet.next()) {
                String email_str = resultSet.getString("email");
                String phone_str = resultSet.getString("phone");  // corrected the typo

                username_txt.setText(PostDetailsController.post_owner);
                phone_txt.setText(phone_str);
                email_txt.setText(email_str);

            }

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public void profile_deatilws(javafx.event.ActionEvent actionEvent) {
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource("post_details.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scene scene2 = new Scene(parent);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Sign Up");

        window.setScene(scene2);
        window.show();
    }

    public void profile_dash(ActionEvent actionEvent) {
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

    public void profile_contract(ActionEvent actionEvent) {
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
}
