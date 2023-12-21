package com.example.libirary_;


import UsersOfLibrary.User;
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
import shoppingcart.Discount;
import shoppingcart.ShoppingCart;
import shoppingcart.commands.TotalPriceCalculator;
import userprofile.Order;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ShoppingCartController implements Initializable {
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
    private Label totalBooksPrice;
    @FXML
    private Button confirmCode;
    @FXML
    private Label promoCodeMessage;
    private final Image backIconDefault = UserInterfaceIcons.goBack;
    private final Image backIconOnHover = UserInterfaceIcons.goBackOnHover;
    private final Image backIconOnClick = UserInterfaceIcons.goBackOnClick;
    private final Image profileIconDefault = UserInterfaceIcons.profile;
    private final Image profileIconOnHover = UserInterfaceIcons.profileOnHover;
    private final Image profileIconOnClick = UserInterfaceIcons.profileOnClick;
    private String promoCode;
    private ShoppingCart shoppingCart;


    @FXML
    void backToHomePage(MouseEvent event) throws IOException {
        backIcon.setImage(backIconOnClick);
        root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }

    @FXML
    void goToProfilePage(MouseEvent event) throws IOException {
        profileIcon.setImage(profileIconOnClick);
        root = FXMLLoader.load(getClass().getResource("UserProfile.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }

    @FXML
    void switchBackIconOnHover(MouseEvent event) {
        backIcon.setImage(backIconOnHover);
    }
    @FXML
    void resetBackIcon(){
        backIcon.setImage(backIconDefault);
    }
    @FXML
    void switchProfileIconOnHover(MouseEvent event) {
        profileIcon.setImage(profileIconOnHover);
    }
    @FXML
    void resetProfileIcon(){
        profileIcon.setImage(profileIconDefault);
    }

    @FXML
    void confirmCodeClicked(){
        promoCode=promoCodeField.getText();
        shoppingCart.applyDiscount(promoCode);
        totalBooksPrice.setText(shoppingCart.getTotalPrice()+ " LE");
    }
    @FXML
    void setPaymentMethod(){
        if(cashOnDelivery.isSelected()){
            shoppingCart.determinePaymentMethod(true);
        } else if (credit.isSelected()) {
            shoppingCart.determinePaymentMethod(false);
        }
    }
    @FXML
    void createNewOrder(){
        Order order = new Order(shoppingCart.getTotalPrice(), LocalDate.now(),shoppingCart.getBookCount());
        User.getCurrentUser().addOrder(order.getOrderId());
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        shoppingCart = new ShoppingCart();

        for(int i = 0; i< shoppingCart.getBooks().size(); i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("ShoppingCartBook.fxml"));
            try{
                HBox newBook = fxmlLoader.load();
                ShoppingCartBookController shoppingCartBookController = fxmlLoader.getController();
                shoppingCartBookController.setData(shoppingCart.getBooks().get(i),shoppingCartBooksList, shoppingCart,totalBooksPrice);
                shoppingCartBooksList.getChildren().add(newBook);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}