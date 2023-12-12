package com.example.libirary_;

import AdminPackage.Admin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

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