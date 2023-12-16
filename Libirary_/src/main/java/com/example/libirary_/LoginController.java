package com.example.libirary_;

import AdminPackage.Admin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import registrationsystem.Login;
import registrationsystem.RegistrationSystem;
import userprofile.Order;

import java.io.IOException;

public class LoginController extends RegistrationSystem implements Login
{
    @FXML
    private void pressLogin(ActionEvent event) throws IOException {
        try{
            User user = this.findUser(this.emailTextField.getText(),this.enterPasswordField.getText());
            if(user != null)
            {
                User.setCurrentUser(user);
                switchToHomePageScene(event);
                return;
            }
            Admin admin = new Admin();
            if(admin.getPassword().equals(this.enterPasswordField.getText())){
                switchToAdminHomePageScene(event);
                return;
            }
            this.showAlert("Data Not Found");
        }
        catch (NullPointerException ex){
            this.showAlert("Data Not Found");
        }
    }
}