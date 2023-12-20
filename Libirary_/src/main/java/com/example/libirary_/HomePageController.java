package com.example.libirary_;

import InterfacesPackage.CommonFunctions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import resourcesimports.UserInterfaceIcons;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController implements CommonFunctions
{
    private Stage stage;
    private Scene scene;
    private Parent root;
    public Image shoppingCartIconDefault = UserInterfaceIcons.shoppingCart;
    public Image shoppingCartIconOnHover = UserInterfaceIcons.shoppingCartOnHover;
    public Image shoppingCartIconOnClick = UserInterfaceIcons.shoppingCartOnClick;
    public Image profileIconDefault = UserInterfaceIcons.profile;
    public Image profileIconOnHover = UserInterfaceIcons.profileOnHover;
    public Image profileIconOnClick = UserInterfaceIcons.profileOnClick;

    @FXML
    ImageView shoppingCartIcon;
    @FXML
    ImageView profileIcon;

    public void BookDetails(MouseEvent e) throws IOException {//Change Scene to BookDetails Page
        String id=e.getPickResult().getIntersectedNode().getId();
        BookDetails bookDetails=new BookDetails();
        bookDetails.setId(id);
        SwitchToNextScene(e,"BookDetails.fxml");

    }
    @FXML
    void switchProfileIconToHover(){
        profileIcon.setImage(profileIconOnHover);
    }
    @FXML
    void resetProfileIcon(){
        profileIcon.setImage(profileIconDefault);
    }
    @FXML
    void switchShoppingCartIconToHover(){
        shoppingCartIcon.setImage(shoppingCartIconOnHover);
    }
    @FXML
    void resetShoppingCartIcon(){
        shoppingCartIcon.setImage(shoppingCartIconDefault);
    }
    @FXML
    void switchToSearch(ActionEvent e) throws IOException{
        SwitchToNextScene(e,"SearchScene.fxml");
    }

    @FXML
    void switchToUserProfile(MouseEvent e) throws IOException{
        profileIcon.setImage(profileIconOnClick);
        SwitchToNextScene(e,"UserProfile.fxml");

    }
    @FXML
    void switchToShoppingCart(MouseEvent e) throws IOException{
        shoppingCartIcon.setImage(shoppingCartIconOnClick);
        SwitchToNextScene(e,"ShoppingCart.fxml");

    }

    @FXML
    public void switchToBookDetails(MouseEvent e) throws IOException{//Change Scene to BookDetails Page
        SwitchToNextScene(e,"BookDetails.fxml");
    }

    @FXML
    public void switchToCategories(ActionEvent e) throws IOException {//Change Scene to Categories Page
        SwitchToNextScene(e,"Categories.fxml");
    }
}
