package com.example.libirary_;

import AdminPackage.Admin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import userprofile.Order;

import java.io.IOException;

public class SignInAsUserSceneController extends RegistrationSystem
{
    @FXML
    private void checkAccount(ActionEvent event) throws IOException {
        try{
            String emailOrUsername  =this.emailTextField.getText();
            String password=this.enterPasswordField.getText();

            for (User user : User.users) {
                System.out.println(user.getEmail());
                System.out.println(user.getName());
                System.out.println(user.getPassword());

                System.out.println(emailOrUsername);
                System.out.println(password);

                if (((user.getEmail().equals(emailOrUsername)) || (user.getName().equals(emailOrUsername))) && user.getPassword().equals(password)) {
                    User.setCurrentUser(user);
                    Order order = new Order(100.0f,Book.books.get(1),3 );
                    user.orders.add(order);
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