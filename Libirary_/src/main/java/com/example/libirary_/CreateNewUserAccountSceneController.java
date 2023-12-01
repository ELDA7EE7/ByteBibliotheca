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
    public boolean checkName(String username){
        for ( char c: username.toCharArray()) {
            if((c>='A'&&c<='Z')||(c>='a'&&c<='z'))
            {
                continue;
            }
            return false;
        }
        return true;
    }
    public boolean checkPasswordIsStrong(String password){
     if(password.length()<10){
         return false;
     }
     boolean isFindChar =false,isFindSymbolOrNumber =false;
        for (char c:password.toCharArray()) {
            if((c>='A'&&c<='Z')||(c>='a'&&c<='z'))
            {
                isFindChar=true;
            }else if(c=='\t'){
                return false;
            }else {
                isFindSymbolOrNumber =true;
            }
        }
        if(isFindChar&&isFindSymbolOrNumber) {
            return true;
        }
        return false;
    }
    public void SignUp(ActionEvent event) {
     boolean signedInSuccessfully = true;
        if(this.checkName(this.username)==false){
           System.out.println("Please Enter only characters in user name field");
           signedInSuccessfully = false;
        }
        if(this.checkPasswordIsStrong(this.password)==false){
            System.out.println("Please Enter StrongPassword with out space ");
            signedInSuccessfully = false;
        }
        if(signedInSuccessfully) {
        // switch to libraryScene
            User newuser = new User(username, email, password);
        }
    }
}
