package com.example.libirary_;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import userprofile.UserProfile;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserProfileSceneController extends UserProfile implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        super.fillListviewWithUserOrders();
        super.fillEmailLabel();
        super.fillIdLabel();
        super.fillNameLabel();
        super.fillPasswordLabel();
    }
    @FXML
    public void BackToHomePage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("HomePageScene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }

}
