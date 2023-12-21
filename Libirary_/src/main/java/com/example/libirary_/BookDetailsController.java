package com.example.libirary_;

import InterfacesPackage.CommonFunctions;
import UsersOfLibrary.Borrower;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static UsersOfLibrary.Borrower.getCurrent_borrower;
import static com.example.libirary_.HomePageController.notifyWhenAvailableBook;
import static librarypackage.Library.getSelectedBook;

public class BookDetailsController implements Initializable , CommonFunctions {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    public ImageView star_1,star_2,star_3,star_4,star_5,backIcon,book1Cover,book2Cover,book3Cover,profileIcon,shoppingCartIcon,bookImage;
    public Image star_1_image,star_2_image,star_3_image,star_4_image,star_5_image;
    @FXML
    public Label Review1,Review2,Username1,Username2,book1Name,book2Name,book3Name,bookDescription,bookName,price,genre,auther,publishDate,rate;
    @FXML
     public Button addToShoppingCart,borrow,confirmReview,notifyWhenAvailable,unBorrow;
    @FXML
    public TextArea reviewArea;
    private boolean resetStarBlooen=true,savedStars=false,isSavedStars;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image imagePath = new Image (getSelectedBook().getCoverPath());
        rate.setText(Float.toString(getSelectedBook().getRating()));
        publishDate.setText(Integer.toString(getSelectedBook().getPublishYear()));
        auther.setText(getSelectedBook().getAuthor());
        bookImage.setImage(imagePath);
        bookDescription.setText(getSelectedBook().getDescription());
        bookName.setText(getSelectedBook().getTitle());
        price.setText(Float.toString(getSelectedBook().getPrice()));
        genre.setText(getSelectedBook().getGenre());
        if(getSelectedBook().getRating()==1)
        {
            display_Star_1();
        }
        else if(getSelectedBook().getRating()==2)
        {
            display_Star_2();
        }
        else if(getSelectedBook().getRating()==3)
        {
            display_Star_3();
        }
        else if(getSelectedBook().getRating()==4)
        {
            display_Star_4();
        }
        else if(getSelectedBook().getRating()==5)
        {
            display_Star_5();
        }
    }
    @FXML
    void switchToShoppingCart(MouseEvent e) throws IOException{
        root= FXMLLoader.load(getClass().getResource("ShoppingCart.fxml"));
        stage=(Stage) ((Node) e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void switchToUserProfile(MouseEvent e) throws IOException {
        root= FXMLLoader.load(getClass().getResource("UserProfile.fxml"));
        stage=(Stage) ((Node) e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void backToHomePage(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }
    @FXML
    void save_Star_1()
    {
        if(!isSavedStars) {
            getSelectedBook().setRating(1);
            isSavedStars=true;
        }
        savedStars=true;
        resetStarBlooen = false;
        star_1_image = new Image("star_fill.png");
        star_1.setImage(star_1_image);
    }
    @FXML
    void save_Star_2()
    {
        if(!isSavedStars) {
            getSelectedBook().setRating(2);
            isSavedStars=true;
        }
        savedStars=true;
        resetStarBlooen = false;
        display_Star_1();
        star_2_image = new Image("star_fill.png");
        star_2.setImage(star_2_image);
    }
    @FXML
    void save_Star_3()
    {
        if(!isSavedStars) {
            getSelectedBook().setRating(3);
            isSavedStars=true;
        }
        savedStars=true;
        resetStarBlooen = false;
        display_Star_2();
        star_3_image = new Image("star_fill.png");
        star_3.setImage(star_3_image);
    }
    public void save_Star_4()
    {
        if(!isSavedStars) {
            getSelectedBook().setRating(4);
            isSavedStars=true;
        }
        savedStars=true;
        resetStarBlooen = false;
        display_Star_3();
        star_4_image = new Image("star_fill.png");
        star_4.setImage(star_4_image);
        resetStarBlooen = false;
    }
    public void save_Star_5()
    {
        if(!isSavedStars) {
            getSelectedBook().setRating(5);
            isSavedStars=true;
        }
        savedStars=true;
        resetStarBlooen = false;
        display_Star_4();
        star_5_image = new Image("star_fill.png");
        star_5.setImage(star_5_image);
        resetStarBlooen = false;
    }
    public void displayStarFrame()
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
    public void resetStars()
    {
        if(resetStarBlooen)
        {
            displayStarFrame();
        }
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
    @FXML
    public void borrowButtonPressed(ActionEvent event){
        getCurrent_borrower().BorrowBook(getSelectedBook());
    }
    @FXML
    public void notifyWhenAvailable(ActionEvent event)
    {
        if(getSelectedBook().isAvailable())
        {
            showAlert("This Book is Available");
            return;
        }
        for (int i=0;i<getCurrent_borrower().BorrowedBookID.size();i++)
        {
            if(getSelectedBook().getBookID()==getCurrent_borrower().BorrowedBookID.get(i))
            {
                showAlert("You Have The Book");
                return;
            }
        }
        for (int i = 0; i< Borrower.getCurrent_borrower().notifyWhenAvailableBook.size(); i++)
        {
            if(getSelectedBook().getBookID()==Borrower.getCurrent_borrower().notifyWhenAvailableBook.get(i).getBookID())
            {
                showAlert("Is already in the wishlist");
                return;
            }
        }
        Borrower.getCurrent_borrower().notifyWhenAvailableBook.add(getSelectedBook());
        System.out.println(notifyWhenAvailableBook.size());
    }
    @FXML
    public void unBorrowBook(ActionEvent event)
    {
        if(getSelectedBook().isAvailable())
        {
            showAlert("you dont the book");
            return;
        }
        for (int i=0;i<getCurrent_borrower().BorrowedBookID.size();i++)
        {
            if(getSelectedBook().getBookID()==getCurrent_borrower().BorrowedBookID.get(i))
            {
                getSelectedBook().setAvailable(true);
                int indx = getCurrent_borrower().BorrowedBookID.size()-1;
                getCurrent_borrower().BorrowedBookID.set(i,getCurrent_borrower().BorrowedBookID.get(indx));
                getCurrent_borrower().BorrowedBookID.remove(indx);
                showAlert("Unborrowed");
                return;
            }
        }
        showAlert("you are not the person who borrowed the book");
    }
}
