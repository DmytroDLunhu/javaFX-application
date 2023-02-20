package com.example.javafxapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SingUpFormController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button SubmitButtonForm;

    @FXML
    private TextField login_field;

    @FXML
    private TextField password_field;

    @FXML
    private RadioButton signUpRadioFemale;

    @FXML
    private RadioButton signUpRadioMale;

    @FXML
    private RadioButton signUpRadioOther;

    @FXML
    private TextField singUpCountry;

    @FXML
    private TextField singUpFirstName;

    @FXML
    private TextField singUpLastName;

    @FXML
    void initialize() {
        SubmitButtonForm.setOnAction(actionEvent -> {
            try {
                signUpNewUser();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void signUpNewUser() throws SQLException, ClassNotFoundException {
        DBHandler dbHandler = new DBHandler();


        String firstName = singUpFirstName.getText();
        String lastName = singUpLastName.getText();
        String userName = login_field.getText();
        String password = password_field.getText();
        String location = singUpCountry.getText();
        String gender = "";
        if (signUpRadioMale.isSelected())
            gender = "Male";
        else if (signUpRadioFemale.isSelected())
            gender = "Female";
        else if (signUpRadioOther.isSelected())
            gender = "Other";
        User user = new User(firstName, lastName, userName, password, location, gender);
        dbHandler.signUpUser(user);

    }
}
