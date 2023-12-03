package com.example.libirary_;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class RegistrationSystem {
    @FXML
    protected TextField
            usernameTextField,
            emailTextField;
    @FXML
    protected PasswordField enterPasswordField,
            confirmPasswordField;
    protected String username,
            email,
            password,
            confirmPassword;
    @FXML
    protected Label confirmpasswordLabel,usernameLabel,enterpasswordLabel,emailLabel;
    private Scene scene;
    private Stage stage;
    @FXML
    public void switchToSignInAsUserScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SignInAsUserScene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void switchToHomePageScene(Node node) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HomePageScene.fxml"));
        stage = (Stage) (node).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void switchToSignInAsAdminScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SignInAsAdminScene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void switchToCreateNewUserAccountScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CreateNewUserAccountScene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void getUsername(ActionEvent event){
        username= usernameTextField.getText();
        System.out.println(username);
    }
    @FXML
    protected void getPassword(ActionEvent event){
        password= enterPasswordField.getText();
        System.out.println(password);

    }
    @FXML
    protected void getEmail(ActionEvent event){
        email= emailTextField.getText();
        System.out.println(email);
    }
    @FXML
    protected void ConfirmPassword(ActionEvent event){
        confirmPassword= confirmPasswordField.getText();
        System.out.println(confirmPassword);
        if (password==null || !password.equals(confirmPassword)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("DataFailed");
            alert.setHeaderText(null);
            alert.setContentText("Password Doesn`t match");
            alert.showAndWait();
            confirmPasswordField.clear();
        }
    }

}
