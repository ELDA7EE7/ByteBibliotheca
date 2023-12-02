package com.example.libirary_;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
public class SignInAsUserSceneController
{
    private Scene scene;
    private Stage stage;
    private Parent root;
    @FXML
    private TextField
            usernameTextField,
            emailTextField;
    @FXML
    private PasswordField enterPasswordField;
    private String username,
            email,
            password;

    public void switchtoHomepageScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void getEmail(ActionEvent event){
        email= emailTextField.getText();
    }
    public void getPassword(ActionEvent event)
    {
        password = enterPasswordField.getText();
    }
    //Checking If The Email Matches With The Password
    public boolean Email_And_Password_Match(String email,String Password,User user)
    {
        //IF True Go To The Hommepage
        if(user.userInfo.getEmail()==email && user.userInfo.getPassword()==password)
        {
            return true;
        }
        ///Else Display Mismatch In The Email Or The Password
        else
        {
            return false;
        }
    }
}
