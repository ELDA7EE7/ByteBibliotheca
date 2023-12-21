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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import librarypackage.Book;
import resourcesimports.UserInterfaceIcons;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static librarypackage.Library.books;
import static librarypackage.Library.setSelectedBook;

public class HomePageController implements Initializable , CommonFunctions
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
    public static ArrayList<Book> notifyWhenAvailableBook = new ArrayList<Book>();

    @FXML
    ImageView shoppingCartIcon;
    @FXML
    ImageView profileIcon;
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
        root= FXMLLoader.load(getClass().getResource("SearchScene.fxml"));
        stage=(Stage) ((Node) e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void switchToUserProfile(MouseEvent e) throws IOException{
        profileIcon.setImage(profileIconOnClick);
        root= FXMLLoader.load(getClass().getResource("UserProfile.fxml"));
        stage=(Stage) ((Node) e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void switchToShoppingCart(MouseEvent e) throws IOException{
        shoppingCartIcon.setImage(shoppingCartIconOnClick);
        root= FXMLLoader.load(getClass().getResource("ShoppingCart.fxml"));
        stage=(Stage) ((Node) e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToBookDetails(MouseEvent e) throws IOException{//Change Scene to BookDetails Page
        ImageView clickedImageView =(ImageView) e.getSource();
        String clickedImageURL= clickedImageView.getImage().getUrl();


        for(Book book:books){
            if(book.testCover().equals(clickedImageURL)){
              setSelectedBook(book);
            }
        }
        root= FXMLLoader.load(getClass().getResource("BookDetails.fxml"));
        stage=(Stage) ((Node) e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToCategories(ActionEvent e) throws IOException {//Change Scene to Categories Page
        root= FXMLLoader.load(getClass().getResource("Categories.fxml"));
        stage=(Stage) ((Node) e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
         ArrayList<Book> B = new ArrayList<Book>();
        for(int i=0;i<Borrower.getCurrent_borrower().notifyWhenAvailableBook.size();i++)
        {
            if(Borrower.getCurrent_borrower().notifyWhenAvailableBook.get(i).isAvailable())
            {
                String out = Borrower.getCurrent_borrower().notifyWhenAvailableBook.get(i).getTitle();
                showAlert(out + "is Available");
            }
            else
            {
                B.add(Borrower.getCurrent_borrower().notifyWhenAvailableBook.get(i));
            }
        }
        Borrower.getCurrent_borrower().notifyWhenAvailableBook.clear();
        Borrower.getCurrent_borrower().notifyWhenAvailableBook.addAll(B);
    }
}
