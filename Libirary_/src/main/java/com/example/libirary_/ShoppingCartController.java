package com.example.libirary_;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import resourcesimports.UserInterfaceIcons;
import java.io.IOException;

public class ShoppingCartController {
    @FXML
    ImageView backIcon;
    @FXML
    ImageView profileIcon;
    Image backIconOnHover = UserInterfaceIcons.goBackIconOnHover;
    Image backIconOnClick = UserInterfaceIcons.goBackIconOnClick;
    Image profileIconOnHover = UserInterfaceIcons.profileOnHover;
    Image profileIconOnClick = UserInterfaceIcons.profileOnClick;
    @FXML
    VBox shoppingCartVBox;
    public void switchBackIconOnHover (){
        backIcon.setImage(backIconOnHover);
    }
    public void switchProfileIconOnHover (){
        backIcon.setImage(profileIconOnHover);
    }
    @FXML
    void backToHomePage(MouseEvent event) throws IOException {
        backIcon.setImage(backIconOnClick);
        Parent root = FXMLLoader.load(getClass().getResource("HomePageScene.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }
    @FXML
    void goToProfilePage(MouseEvent event) throws IOException {
        backIcon.setImage(profileIconOnClick);
        Parent root = FXMLLoader.load(getClass().getResource("HomePageScene.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }
}
