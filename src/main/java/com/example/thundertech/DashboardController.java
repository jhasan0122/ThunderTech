package com.example.thundertech;


import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {

    static int domain = 0;

    @FXML
    void ai(ActionEvent event) {
        domain = 10;
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource("post.fxml"));
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
    void ap(ActionEvent event) {
        domain = 4;
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource("post.fxml"));
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
    void contract_manager(ActionEvent event) {

    }

    @FXML
    void dd(ActionEvent event) {
        domain = 9;
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource("post.fxml"));
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
    void dl(ActionEvent event) {
        domain = 7;
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource("post.fxml"));
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
    void ht(ActionEvent event) {
        domain = 2;
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource("post.fxml"));
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
    void io(ActionEvent event) {
        domain = 5;
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource("post.fxml"));
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
    void js(ActionEvent event) {
        domain = 3;
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource("post.fxml"));
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
    void ml(ActionEvent event) {
        domain = 6;
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource("post.fxml"));
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
    void py(ActionEvent event) {
        domain = 1;
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource("post.fxml"));
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
    void wb(ActionEvent event) {
        domain = 8;
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource("post.fxml"));
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
