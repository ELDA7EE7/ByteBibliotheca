package com.example.libirary_;

import InterfacesPackage.CommonFunctions;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import librarypackage.Book;
import resourcesimports.UserInterfaceIcons;
import shoppingcart.ShoppingCart;
import shoppingcart.commands.TotalPriceCalculator;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ShoppingCartController implements Initializable, CommonFunctions {
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private ImageView backIcon;

    @FXML
    private RadioButton cashOnDelivery;

    @FXML
    private Button confirmOrder;

    @FXML
    private RadioButton credit;

    @FXML
    private ToggleGroup payment;

    @FXML
    private ImageView profileIcon;

    @FXML
    private TextField promoCodeField;

    @FXML
    private VBox shoppingCartBooksList;

    @FXML
    private Label totalPrice;
    Image backIconOnHover = UserInterfaceIcons.goBackOnHover;
    Image backIconOnClick = UserInterfaceIcons.goBackOnClick;
    Image profileIconOnHover = UserInterfaceIcons.profileOnHover;
    Image profileIconOnClick = UserInterfaceIcons.profileOnClick;
    private ShoppingCart shoppingCart;
    private TotalPriceCalculator totalPriceCalculator = new TotalPriceCalculator();


    @FXML
    void backToHomePage(MouseEvent event) throws IOException {
        backIcon.setImage(backIconOnClick);
        SwitchToNextScene(event,"HomePage.fxml");

    }

    @FXML
    void goToProfilePage(MouseEvent event) throws IOException {
        profileIcon.setImage(profileIconOnClick);
      SwitchToNextScene(event,"UserProfile.fxml");
    }

    @FXML
    void switchBackIconOnHover(MouseEvent event) {
        backIcon.setImage(backIconOnHover);
    }

    @FXML
    void switchProfileIconOnHover(MouseEvent event) {
        profileIcon.setImage(profileIconOnHover);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        shoppingCart = new ShoppingCart();
        List<Book> shoppingCartBooks = new ArrayList<>(shoppingCartBooks());
        shoppingCart.setBooks(shoppingCartBooks());
        for(int i =0;i<shoppingCartBooks.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("ShoppingCartBook.fxml"));
            try{
                HBox newBook = fxmlLoader.load();
                ShoppingCartBookController shoppingCartBookController = fxmlLoader.getController();
                shoppingCartBookController.setData(shoppingCartBooks.get(i),shoppingCartBooksList);
                shoppingCartBooksList.getChildren().add(newBook);
            } catch (IOException e){
                e.printStackTrace();
            }
        }

    }
    private List<Book> shoppingCartBooks(){
        List<Book> ls =new ArrayList<>();
        Book book = new Book("It Ends with Us","Colleen Hoover","","In Stock",2016,4.7f,90f,"Romance","",true,12,5);
        ls.add(book);
        return ls;
    }
}