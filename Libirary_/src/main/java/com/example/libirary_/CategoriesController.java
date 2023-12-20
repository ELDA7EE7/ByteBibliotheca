package com.example.libirary_;

import InterfacesPackage.CommonFunctions;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import resourcesimports.UserInterfaceIcons;

import java.io.IOException;

import static librarypackage.Library.books;

public class CategoriesController implements CommonFunctions {
    public Image shoppingCartIconOnHover = UserInterfaceIcons.shoppingCartOnHover;
    public Image shoppingCartIconOnClick = UserInterfaceIcons.shoppingCartOnClick;
    public Image profileIconOnHover = UserInterfaceIcons.profileOnHover;
    public Image profileIconOnClick = UserInterfaceIcons.profileOnClick;
    @FXML
    ImageView shoppingCartIcon;
    @FXML
    ImageView profileIcon;
    @FXML
    void switchProfileIconToHover(){
        profileIcon.setImage(profileIconOnHover);
    }
    @FXML
    void switchShoppingCartIconToHover(){
        shoppingCartIcon.setImage(shoppingCartIconOnHover);
    }
    @FXML
    void switchToSearch(ActionEvent e) throws IOException {
        SwitchToNextScene(e,"SearchScene.fxml");
    }

    @FXML
    void switchToUserProfile(ActionEvent e) throws IOException{
        profileIcon.setImage(profileIconOnClick);
        SwitchToNextScene(e,"UserProfile.fxml");

    }

    @FXML
    public void switchToShoppingCart(MouseEvent e) throws IOException { //Change Scene to Cart Page
        profileIcon.setImage(shoppingCartIconOnClick);
        SwitchToNextScene(e,"ShoppingCart.fxml");
    }

    @FXML
    public void switchToBookDetails(MouseEvent e) throws IOException{//Change Scene to BookDetails Page
        SwitchToNextScene(e, "BookDetails.fxml");
    }

    @FXML
    public void switchToCategories(ActionEvent e) throws IOException {//Change Scene to Categories Page
        System.out.println(books.size());
        SwitchToNextScene(e,"Categories.fxml");
    }
}
