package com.example.libirary_;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CreateNewUserAccountSceneController {
    @FXML
    private TextField
            usernameTextField,
            emailTextField;
    @FXML
    private PasswordField enterPasswordField,
            confirmPasswordField;
    private String username,
            email,
            password,
            confirmPassword;
    @FXML
    private Label confirmpasswordLabel;
    @FXML
    private Button signupButton;

    public void getUsername(ActionEvent event){
        username= usernameTextField.getText();
        System.out.println(username);
    }
    public void getPassword(ActionEvent event){
        if(username == null)
            usernameTextField.setText("");
        password= enterPasswordField.getText();
        System.out.println(password);

    }
    public void getEmail(ActionEvent event){
        email= emailTextField.getText();
        System.out.println(email);
    }
    public void ConfirmPassword(ActionEvent event){
        confirmPassword= confirmPasswordField.getText();
        System.out.println(confirmPassword);
        if (!password.equals(confirmPassword)){
            confirmpasswordLabel.setText("Password does not match");
            confirmPasswordField.clear();
        }
        else {
            confirmpasswordLabel.setText("");
        }
    }
    public void SignUp(ActionEvent event) {

        User newuser = new User(username,email,password);

    }
}
