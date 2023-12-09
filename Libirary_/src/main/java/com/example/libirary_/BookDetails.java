package com.example.libirary_;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BookDetails implements Initializable
{
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    Label titleID,autherID,publishYearID,priceID,genreID,statusID;
    @FXML
    ImageView imageID;
    Button back;
    public void displayBook(Book book)
    {
        Image imagePath = new Image (book.getImagepath());
        imageID.setImage(imagePath);
        titleID.setText(book.getTitle());
        autherID.setText(book.getAuthor());
        publishYearID.setText(Integer.toString(book.getPublishYear()));
        priceID.setText(Float.toString(book.getPrice()));
        genreID.setText(book.getGenre());
        statusID.setText(book.getStatus());
    }
    //Waiting for Interface To Go back to Homepage
    @FXML
    void backToHomePage()
    {
        //BackToHomePage(back);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Book book=new Book("mazen","mazen","In stock",2005,2000.0F,"Action","berserk1.jpg");
        displayBook(book);
    }
}