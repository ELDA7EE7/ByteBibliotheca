package com.example.libirary_;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
public class SignInAsUserSceneController extends RegistrationSystem
{
    @FXML
    private void checkAccount(ActionEvent event) throws IOException {
        try{
            String emailOrUsername  =this.emailTextField.getText();
            String password=this.enterPasswordField.getText();

            for (User user : User.users) {
                System.out.println(user.userInfo.email);

                System.out.println(user.userInfo.userName);

                System.out.println(user.userInfo.password);
                if (((user.userInfo.email.equals(emailOrUsername)) || (user.userInfo.userName.equals(emailOrUsername))) && user.userInfo.password.equals(password)) {
                    switchToHomePageScene(event);
                    return;
                }
            }
            Admin admin = new Admin();
            if(admin.getPassword().equals(password)){
                switchToAdminHomePageScene(event);
                return;
            }
            this.showAlert("Data Not Found");
        }catch (NullPointerException ex){
            this.showAlert("please enter information then please press enter");
        }
    }
}