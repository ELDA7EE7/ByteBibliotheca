package com.example.libirary_;

import InterfacesPackage.CommonFunctions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import userprofile.UpdateUserData;
import userprofile.UserProfile;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserProfileSceneController extends UpdateUserData implements Initializable, CommonFunctions {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    Button logoutButton;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        super.fillListviewWithUserOrders();
        super.fillEmailLabel();
        super.fillIdLabel();
        super.fillNameLabel();
        super.fillPasswordLabel();
    }
    @FXML
    public void backToHomePage(ActionEvent event) throws IOException {
        SwitchToNextScene(event,"HomePageScene.fxml");
    }
    private void switchToLoginScene(ActionEvent event)throws IOException{
        SwitchToNextScene(event,"LogInAsUserScene.fxml");
    }
    @FXML
    public void pressLogoutButton(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("press OK to logout");

        if (alert.showAndWait().get() == ButtonType.OK){
            System.out.println("You successfully logged out");
            switchToLoginScene(event);
        }
    }
}
