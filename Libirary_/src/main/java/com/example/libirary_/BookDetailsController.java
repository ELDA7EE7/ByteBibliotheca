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
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import librarypackage.Book;
import resourcesimports.UserInterfaceIcons;
import shoppingcart.ShoppingCart;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


import static UsersOfLibrary.Borrower.getCurrent_borrower;
import static librarypackage.Library.*;

public class BookDetailsController implements Initializable, CommonFunctions {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private final Image backIconDefault = UserInterfaceIcons.goBack;
    private final Image backIconOnHover = UserInterfaceIcons.goBackOnHover;
    private final Image backIconOnClick = UserInterfaceIcons.goBackOnClick;
    private final Image profileIconDefault = UserInterfaceIcons.profile;
    private final Image profileIconOnHover = UserInterfaceIcons.profileOnHover;
    private final Image profileIconOnClick = UserInterfaceIcons.profileOnClick;
    public Image shoppingCartIconDefault = UserInterfaceIcons.shoppingCart;
    public Image shoppingCartIconOnHover = UserInterfaceIcons.shoppingCartOnHover;
    public Image shoppingCartIconOnClick = UserInterfaceIcons.shoppingCartOnClick;
    @FXML
    public ImageView star_1,star_2,star_3,star_4,star_5,backIcon,book1Cover,book2Cover,book3Cover,profileIcon,shoppingCartIcon,bookImage;
    private Image star1 = UserInterfaceIcons.Star1,star2= UserInterfaceIcons.Star2,star3= UserInterfaceIcons.Star3,star4= UserInterfaceIcons.Star4,star5= UserInterfaceIcons.Star5;
    private Image star1Selected = UserInterfaceIcons.Star1Selected,star2Selected = UserInterfaceIcons.Star2Selected,star3Selected = UserInterfaceIcons.Star3Selected,star4Selected = UserInterfaceIcons.Star4Selected,star5Selected = UserInterfaceIcons.Star5Selected;
    @FXML
    public Label Review1,Review2,Username1,Username2,book1Name,book2Name,book3Name,bookDescription,bookName,price,genre,auther,publishDate,rate;
    @FXML
    public Button addToShoppingCart,borrow,confirmReview,notifyWhenAvailable;
    @FXML
    public TextArea reviewArea;
    private boolean resetStarBlooen=true,savedStars=false;
    int bookID;

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
    void switchShoppingCartIconToHover(){
        shoppingCartIcon.setImage(shoppingCartIconOnHover);
    }
    @FXML
    void resetShoppingCartIcon(){
        shoppingCartIcon.setImage(shoppingCartIconDefault);
    }
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
        showSimilarBooks();
    }
    @FXML
    void switchToShoppingCart(MouseEvent e) throws IOException{
        shoppingCartIcon.setImage(shoppingCartIconOnClick);
        root= FXMLLoader.load(getClass().getResource("ShoppingCart.fxml"));
        stage=(Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.getScene().setRoot(root);
        /*scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setFullScreen(true);*/
    }
    @FXML
    void switchToUserProfile(MouseEvent e) throws IOException {
        profileIcon.setImage(profileIconOnClick);
        root= FXMLLoader.load(getClass().getResource("UserProfile.fxml"));
        stage=(Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.getScene().setRoot(root);
        /*scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setFullScreen(true);*/
    }
    @FXML
    void backToHomePage(MouseEvent event) throws IOException {
        backIcon.setImage(backIconOnClick);
        root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.getScene().setRoot(root);
        /*scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setFullScreen(true);*/
    }
    @FXML
    void switchStar1OnHover(){
        star_1.setImage(star1Selected);
    }
    @FXML
    void switchStar2OnHover(){
        switchStar1OnHover();
        star_2.setImage(star2Selected);
    }
    @FXML
    void switchStar3OnHover(){
        switchStar2OnHover();
        star_3.setImage(star3Selected);
    }
    @FXML
    void switchStar4OnHover(){
        switchStar3OnHover();
        star_4.setImage(star4Selected);
    }
    @FXML
    void switchStar5OnHover(){
        switchStar4OnHover();
        star_5.setImage(star5Selected);
    }
    @FXML
    void resetStar1Icon(){
        star_1.setImage(star1);
    }
    @FXML
    void resetStar2Icon(){
        resetStar1Icon();
        star_2.setImage(star2);
    }
    @FXML
    void resetStar3Icon(){
        resetStar2Icon();
        star_3.setImage(star3);
    }
    @FXML
    void resetStar4Icon(){
        resetStar3Icon();
        star_4.setImage(star4);
    }
    @FXML
    void resetStar5Icon(){
        resetStar4Icon();
        star_5.setImage(star5);
    }
    @FXML
    void select1StarRating(){
        switchStar1OnHover();
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Set Rating to 1");
        alert1.setHeaderText("Do you want to give this book one star rating?");
        if (alert1.showAndWait().get() == ButtonType.OK){
            switchStar1OnHover();
        }
        else{
            resetStar1Icon();
        }
    }
    @FXML
    void select2StarRating(){
        switchStar2OnHover();
        Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
        alert2.setTitle("Set Rating to 2");
        alert2.setHeaderText("Do you want to give this book two stars rating?");
        if (alert2.showAndWait().get() == ButtonType.OK){
            switchStar2OnHover();
        }
        else{
            resetStar2Icon();
        }
    }
    @FXML
    void select3StarRating(){
        switchStar3OnHover();
        Alert alert3 = new Alert(Alert.AlertType.CONFIRMATION);
        alert3.setTitle("Set Rating to 3");
        alert3.setHeaderText("Do you want to give this book three stars rating?");
        if (alert3.showAndWait().get() == ButtonType.OK){
            switchStar3OnHover();
        }
        else{
            resetStar3Icon();
        }
    }
    @FXML
    void select4StarRating(){
        switchStar4OnHover();
        Alert alert4 = new Alert(Alert.AlertType.CONFIRMATION);
        alert4.setTitle("Set Rating to 4");
        alert4.setHeaderText("Do you want to give this book four stars rating?");
        if (alert4.showAndWait().get() == ButtonType.OK){
            switchStar4OnHover();
        }
        else{
            resetStar4Icon();
        }
    }
    @FXML
    void select5StarRating(){
        switchStar5OnHover();
        Alert alert5 = new Alert(Alert.AlertType.CONFIRMATION);
        alert5.setTitle("Set Rating to 5");
        alert5.setHeaderText("Do you want to give this book five stars rating?");
        if (alert5.showAndWait().get() == ButtonType.OK){
            switchStar5OnHover();
        }
        else{
            resetStar5Icon();
        }
    }

    @FXML
    public void borrowButtonPressed(ActionEvent event){
        getCurrent_borrower().BorrowBook(getSelectedBook());
    }
    @FXML
    void addBookToShoppingCart(){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addBook(getSelectedBook());
    }
    @FXML
    public void notifyWhenAvailable(ActionEvent event)
    {
        if(getSelectedBook().isAvailable())
        {
            showAlert("This Book is Available.");
            return;
        }
        for (int i=0;i<getCurrent_borrower().BorrowedBookID.size();i++)
        {
            if(getSelectedBook().getBookID()==getCurrent_borrower().BorrowedBookID.get(i))
            {
                showAlert("You already borrowed the book.");
                return;
            }
        }
        for (int i = 0; i< Borrower.getCurrent_borrower().notifyWhenAvailableBook.size(); i++)
        {
            if(getSelectedBook().getBookID()==Borrower.getCurrent_borrower().notifyWhenAvailableBook.get(i).getBookID())
            {
                showAlert("This book is already in the wishlist.");
                return;
            }
        }
        Borrower.getCurrent_borrower().notifyWhenAvailableBook.add(getSelectedBook());
    }
    @FXML
    public void unBorrowBook(ActionEvent event)
    {
        if(getSelectedBook().isAvailable())
        {
            showAlert("You don't own the book.");
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
                showAlert("Book returned successfully");
                return;
            }
        }
        showAlert("You are not the person who borrowed the book");
    }
    public void showSimilarBooks(){
        int counter=0;
        for (Book book:books){
            if(book.getBookID()!=getSelectedBook().getBookID() &&(book.getAuthor().equals(getSelectedBook().getAuthor())|| book.getGenre().equals(getSelectedBook().getGenre()))){
                if(counter==0) {
                    book1Name.setText(book.getTitle());
                    book1Cover.setImage(new Image(book.getCoverPath()));
                } else if (counter==1) {
                    book2Name.setText(book.getTitle());
                    book2Cover.setImage(new Image(book.getCoverPath()));
                } else if (counter==2) {
                    book3Name.setText(book.getTitle());
                    book3Cover.setImage(new Image(book.getCoverPath()));
                } else{
                    break;
                }
                counter++;
            }
        }
        if(counter<3){
            for(Book book:books){
                if(!book.getTitle().equals(getSelectedBook().getTitle())
                        && !book1Name.getText().equals(book.getTitle())
                        && !book2Name.getText().equals(book.getTitle())){
                    if(counter==0) {
                        book1Name.setText(book.getTitle());
                        book1Cover.setImage(new Image(book.getCoverPath()));
                    } else if (counter==1) {
                        book2Name.setText(book.getTitle());
                        book2Cover.setImage(new Image(book.getCoverPath()));
                    } else if (counter==2) {
                        book3Name.setText(book.getTitle());
                        book3Cover.setImage(new Image(book.getCoverPath()));
                    } else if (counter==3){
                        break;
                    }
                    counter++;
                }
            }
        }
    }
    @FXML
    public void switchToAnotherBook(MouseEvent e) throws IOException {
        ImageView clickedImageView =(ImageView) e.getSource();
        String clickedImageURL= clickedImageView.getImage().getUrl();


        for(Book book:books){
            if(book.testCover().equals(clickedImageURL)){
                setSelectedBook(book);
            }
        }
        Parent root= FXMLLoader.load(getClass().getResource("BookDetails.fxml"));
        Stage stage=(Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.getScene().setRoot(root);
        /*scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setFullScreen(true);*/
    }
}
