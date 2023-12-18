package com.example.libirary_;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

import static librarypackage.Library.getSelectedBook;

public class BookDetailsController implements Initializable {
    @FXML
    public Label Review1;

    @FXML
    public Label Review2;

    @FXML
    public Label Username1;

    @FXML
    public Label Username2;

    @FXML
     public Button addToShoppingCart;

    @FXML
    public ImageView backIcon;

    @FXML
    public ImageView book1Cover;

    @FXML
    public Label book1Name;

    @FXML
    public ImageView book2Cover;

    @FXML
    public Label book2Name;

    @FXML
    public ImageView book3Cover;

    @FXML
    public Label book3Name;

    @FXML
    public Label bookDescription;

    @FXML
    public Label bookName;

    @FXML
    public Button borrow;

    @FXML
    public Button confirmReview;

    @FXML
    public Button notifyWhenAvailable;

    @FXML
    public ImageView profileIcon;

    @FXML
    public TextArea reviewArea;

    @FXML
    public ImageView shoppingCartIcon;

    @FXML
    public ImageView bookImage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image imagePath = new Image (getSelectedBook().getCoverPath());
        bookImage.setImage(imagePath);
    }
}
