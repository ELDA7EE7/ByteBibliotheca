package com.example.libirary_;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.regex.Pattern;

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
    private Label confirmpasswordLabel,usernameLabel,enterpasswordLabel,emailLabel;
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
        if (password==null || !password.equals(confirmPassword)){
            confirmpasswordLabel.setText("* Password does not match");
            confirmPasswordField.clear();
        }
        else {
            confirmpasswordLabel.setText("");
        }
    }
    private boolean checkName(String username){
        for ( char c: username.toCharArray()) {
            if((c>='A'&&c<='Z')||(c>='a'&&c<='z'))
            {
                continue;
            }
            return false;
        }
        return true;
    }
    private boolean checkPasswordIsStrong(String password){
     if(password.length()<8){
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

    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        return pattern.matcher(email).matches();
    }
    public void SignUp(ActionEvent event) {
     boolean signedInSuccessfully = true;
        if(this.checkName(this.username)==false){
           System.out.println("Please Enter only characters in user name field");
           usernameLabel.setText("* Please Enter only characters in user name field");
           usernameTextField.clear();
           signedInSuccessfully = false;
        }
        if(this.checkPasswordIsStrong(this.password)==false){
            System.out.println("Please Enter Strong Password with out space ");
            enterpasswordLabel.setText("* Please Enter Strong Password with out space");
            enterPasswordField.clear();
            confirmPasswordField.clear();
            signedInSuccessfully = false;
        }
        if(!this.isValidEmail(email)){
            System.out.println("invalid email");
            signedInSuccessfully = false;
        }
        if(signedInSuccessfully) {
        // switch to libraryScene
            usernameLabel.setText("");
            enterpasswordLabel.setText("");
            User newuser = new User(username, email, password);
        }
    }
}
