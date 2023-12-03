package com.example.libirary_;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.regex.Pattern;

public class CreateNewUserAccountSceneController extends RegistrationSystem {

    @FXML
    private Button signupButton;

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
    public void SignUp(ActionEvent event) throws IOException {
     boolean signedInSuccessfully = true;
        if(this.checkName(this.username)==false){
           System.out.println("Please Enter only characters in user name field");
         //  usernameLabel.setText("* Please Enter only characters in user name field");
           usernameTextField.clear();
           signedInSuccessfully = false;
        }
        if(this.checkPasswordIsStrong(this.password)==false){
            System.out.println("Please Enter Strong Password with out space ");
           // enterpasswordLabel.setText("* Please Enter Strong Password with out space");
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
            switchToHomePageScene(signupButton);
            usernameLabel.setText("");
            enterpasswordLabel.setText("");
            User newuser = new User(username, email, password);
        }
        else
        {
            // Alert
            /*Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Data Failed");
            alert.setContentText("email format must be correct and Password Must be Strong ");
            alert.showAndWait();*/
            enterPasswordField.clear();
            confirmPasswordField.clear();
            usernameTextField.clear();
            emailTextField.clear();
        }
    }
}
