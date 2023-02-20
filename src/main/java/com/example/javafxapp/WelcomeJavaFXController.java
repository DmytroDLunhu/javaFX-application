package com.example.javafxapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WelcomeJavaFXController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button loginSignINbutton;

    @FXML
    private Button loginSignUPbutton;

    @FXML
    private TextField login_field;

    @FXML
    private TextField password_field;

    @FXML
    void initialize() {
        loginSignINbutton.setOnAction(event -> {
            String login = login_field.getText().trim();
            String loginPass = password_field.getText().trim();
            if (!login.equals("") && !loginPass.equals("")) {
                loginUser(login, loginPass);
                {
                    System.out.println("Login or password is empty");
                }
            }
        });
        loginSignUPbutton.setOnAction((actionEvent -> {
            loginSignUPbutton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/javafxapp/signUpForm.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        }));
    }

    private void loginUser(String login, String loginPass) {
    }
}


