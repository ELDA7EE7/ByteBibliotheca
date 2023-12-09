package com.example.libirary_;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Pattern;

public interface CommonFunctions {


    default void BackToAdmin(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("AdminHomePage.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }
    default void showAlert(String message){
        // Alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    default void BackToHomePage(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("HomePageScene.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }
    default boolean checkName(String username){
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
    default boolean checkPasswordIsStrong(String password){
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
    default boolean isValidEmail(String email) {
        if(email==null)
        {
            //    this.emailTextField.clear();
            return false;
        }
        String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        return pattern.matcher(email).matches();
    }

}
