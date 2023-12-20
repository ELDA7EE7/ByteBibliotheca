package com.example.libirary_;

import displaybook.SaveStar;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import librarypackage.Book;

import java.net.URL;
import java.util.ResourceBundle;

import static librarypackage.Library.books;

public class BookDetails extends SaveStar implements Initializable
{
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    Label titleID,autherID,publishYearID,priceID,genreID,statusID;
    @FXML
    ImageView imageID,star_1,star_2,star_3,star_4,star_5;
    Image star_1_image,star_2_image,star_3_image,star_4_image,star_5_image;
    private boolean resetStarBlooen=true,savedStars=false;
    Button back,borrowID;

    public void displayBook(Book book)
    {
        Image imagePath = new Image (book.getCoverPath());
        imageID.setImage(imagePath);
        titleID.setText(book.getTitle());
        autherID.setText(book.getAuthor());
        publishYearID.setText(Integer.toString(book.getPublishYear()));
        priceID.setText(Float.toString(book.getPrice()));
        genreID.setText(book.getGenre());
        statusID.setText(book.getStatus());
        star_1_image = new Image("star_before.png");
        star_2_image = new Image("star_before.png");
        star_3_image = new Image("star_before.png");
        star_4_image = new Image("star_before.png");
        star_5_image = new Image("star_before.png");
        star_1.setImage(star_1_image);
        star_2.setImage(star_2_image);
        star_3.setImage(star_3_image);
        star_4.setImage(star_4_image);
        star_5.setImage(star_5_image);
    }
    private static String id;
    public void setId(String id){
        this.id=id;
        System.out.println(id);
        System.out.println(this.id);
    }
    //Waiting for Interface To Go back to Homepage
    @FXML
    void backToHomePage()
    {
        //BackToHomePage(back);
    }
    @FXML
    public void Borrow()
    {
        //function Ehab & akram


        System.out.printf("borrow");
    }
    @FXML
    public void purchase()
    {
        System.out.printf("purchase");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (int i=0;i<books.size();i++) {
            // Book book = new Book("mazen", "mazen", "In stock", 2005, 2000.0F, "Action", "berserk1.jpg", true, 5, 1);
            if((books.get(i).getTitle().compareTo(id))==0){
                displayBook(books.get(i));
            }
        }
    }


}