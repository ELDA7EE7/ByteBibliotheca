package com.example.libirary_;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

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
    //Waiting for Interface To Go back to Homepage
    @FXML
    void backToHomePage()
    {
        //BackToHomePage(back);
    }
    @FXML
    public void Borrow()
    {
        System.out.printf("borrow");
    }
    @FXML
    public void purchase()
    {
        System.out.printf("purchase");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Book book=new Book("mazen","mazen","In stock",2005,2000.0F,"Action","berserk1.jpg",true,5,1);
        displayBook(book);
    }
    public void save_Star_1()
    {
        savedStars=true;
        resetStarBlooen = false;
        star_1_image = new Image("star_fill.png");
        star_1.setImage(star_1_image);
    }
    public void save_Star_2()
    {
        savedStars=true;
        resetStarBlooen = false;
        display_Star_1();
        star_2_image = new Image("star_fill.png");
        star_2.setImage(star_2_image);
    }
    public void save_Star_3()
    {
        savedStars=true;
        resetStarBlooen = false;
        display_Star_2();
        star_3_image = new Image("star_fill.png");
        star_3.setImage(star_3_image);
    }
    public void save_Star_4()
    {
        savedStars=true;
        resetStarBlooen = false;
        display_Star_3();
        star_4_image = new Image("star_fill.png");
        star_4.setImage(star_4_image);
        resetStarBlooen = false;
    }
    public void save_Star_5()
    {
        savedStars=true;
        resetStarBlooen = false;
        display_Star_4();
        star_5_image = new Image("star_fill.png");
        star_5.setImage(star_5_image);
        resetStarBlooen = false;
    }
    public void display_Star_1() {
        if (!savedStars) {
            resetStars();
            star_1_image = new Image("star_fill.png");
            star_1.setImage(star_1_image);
        }
    }
    public void display_Star_2() {
        if (!savedStars) {
            resetStars();
            display_Star_1();
            star_2_image = new Image("star_fill.png");
            star_2.setImage(star_2_image);
        }
    }
    public void display_Star_3() {
        if (!savedStars) {
            resetStars();
            display_Star_2();
            star_3_image = new Image("star_fill.png");
            star_3.setImage(star_3_image);
        }
    }
    public void display_Star_4() {
        if (!savedStars) {
            resetStars();
            display_Star_3();
            star_4_image = new Image("star_fill.png");
            star_4.setImage(star_4_image);
        }
    }
    public void display_Star_5()
    {
        if(!savedStars) {
            resetStars();
            display_Star_4();
            star_5_image = new Image("star_fill.png");
            star_5.setImage(star_5_image);
        }
    }
    public void resetStars()
    {
        if(resetStarBlooen)
        {
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
    }
}