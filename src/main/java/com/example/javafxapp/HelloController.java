package com.example.javafxapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController {

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
        assert loginSignINbutton != null : "fx:id=\"loginSignINbutton\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert loginSignUPbutton != null : "fx:id=\"loginSignUPbutton\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert login_field != null : "fx:id=\"login_field\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert password_field != null : "fx:id=\"password_field\" was not injected: check your FXML file 'hello-view.fxml'.";
        loginSignINbutton.setOnAction((actionEvent ->
        {
            System.out.println("Button SIGN IN clicked!");
        }));
        loginSignUPbutton.setOnAction((actionEvent ->
        {
            System.out.println("Button SIGN UP clicked!");
        }));
    }
}

