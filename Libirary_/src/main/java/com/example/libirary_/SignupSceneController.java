package com.example.libirary_;

import UsersOfLibrary.Borrower;
import UsersOfLibrary.Customer;
import UsersOfLibrary.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import registrationsystem.RegistrationSystem;
import registrationsystem.SignUp;

import java.io.IOException;

import static com.example.libirary_.MainClass.emailsTrie;
import static com.example.libirary_.MainClass.namesTrie;

public class SignupSceneController extends RegistrationSystem implements SignUp {


    @Override@FXML
    public void clickSignUp(ActionEvent event) throws IOException {
        try {
            String username =this.usernameTextField.getText();
            String email = this.emailTextField.getText();
            String password = this.enterPasswordField.getText();

            boolean signedInSuccessfully = true;
            if (!this.isValidEmail(email)||!this.checkPasswordIsStrong(password)||!this.checkName(username)) {
                signedInSuccessfully = false;
            }
            if (signedInSuccessfully){
                //add user to system
                User newuser = new User(username, email, password);
                 namesTrie.insert(username);
                emailsTrie.insert(email);
                //add this data to currentUser
                User.setCurrentUser(newuser);

                Borrower borrower =new Borrower(newuser.getId(), newuser.getName(), newuser.getEmail(), newuser.getPassword());
                Customer purchase=new Customer(newuser.getId(), newuser.getName(), newuser.getEmail(), newuser.getPassword());
                //go to home page
                switchToHomePageScene(event);
            }else{
                System.out.println(username+email+password);
                clearFields();
            }
        }catch (NullPointerException ex){
            System.out.println(ex.getMessage());
            this.showAlert("please fill all Fields");
        }
    }

    @Override
    public void clearFields() {
        this.showAlert("Constraints : Name(only characters),Email(email Format),Password(must be strong) OR maybe data is Used");
        enterPasswordField.clear();
        usernameTextField.clear();
        emailTextField.clear();
    }
    public void BackToLoginPage(ActionEvent event) throws IOException{
        switchToSignInAsUserScene(event);
    }
}
