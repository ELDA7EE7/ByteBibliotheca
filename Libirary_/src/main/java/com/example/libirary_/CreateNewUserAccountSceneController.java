package com.example.libirary_;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.regex.Pattern;

public class CreateNewUserAccountSceneController extends RegistrationSystem {
    private boolean checkName(String username){
        if(username==null) {
    //        this.usernameTextField.clear();
            return false;
        }
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
        if(password==null){
      //      this.confirmPasswordField.clear();
            return false;
        }
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
        if(email==null)
        {
        //    this.emailTextField.clear();
            return false;
        }
        String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        return pattern.matcher(email).matches();
    }
    @FXML
    public void SignUp(ActionEvent event) throws IOException {
        try {
            this.username =this.usernameTextField.getText();
            this.email = this.emailTextField.getText();
            this.password = this.enterPasswordField.getText();

            boolean signedInSuccessfully = true;
            if (this.checkName(this.username) == false) {
                System.out.println("Please enter characters only in user name field.");
                //  usernameLabel.setText("* Please Enter only characters in user name field");
                usernameTextField.clear();
                signedInSuccessfully = false;
            }
            if (this.checkPasswordIsStrong(this.password) == false) {
                System.out.println("Please enter a stronger password without any space.");
                // enterpasswordLabel.setText("* Please Enter Strong Password with out space");
                enterPasswordField.clear();
                signedInSuccessfully = false;
            }
            if (!this.isValidEmail(email)) {
                System.out.println("Please enter a valid email.");
                signedInSuccessfully = false;
            }
            if (signedInSuccessfully) {
                // switch to libraryScene
                switchToHomePageScene(event);
                User newuser = new User(username, email, password);
            } else {
                this.showAlert("Email format must be correct and password must be strong.");
                enterPasswordField.clear();
                usernameTextField.clear();
                emailTextField.clear();
            }
        }catch (NullPointerException ex){
            System.out.println(ex.getMessage());
            this.showAlert("Enter information then press enter, please.");
        }
    }
    public void BackToLoginPage(ActionEvent event) throws IOException{
        switchToSignInAsUserScene(event);
    }
}
