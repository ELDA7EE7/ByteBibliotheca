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
import librarypackage.Book;
import resourcesimports.UserInterfaceIcons;
import java.io.IOException;
import static librarypackage.Library.books;
import static librarypackage.Library.setSelectedBook;

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
    public void switchToCategories(ActionEvent e) throws IOException {//Change Scene to Categories Page
        System.out.println(books.size());
       SwitchToNextScene(e,"Categories.fxml");
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
       SwitchToNextScene(e,"BookDetails.fxml");
    }
    private static Image image=new Image("berserk1.jpg");
    @FXML
    private ImageView rand;
    private static int last_value=-1;
    public void random(ActionEvent e) throws IOException
    {
        int max = books.size()-1;
        int min = 0;
        int range = max - min + 1;
        int rando = (int)(Math.random() * range) + min;
        while (last_value==rando) {
            rando = (int) (Math.random() * range) + min;
        }
        String path = books.get(rando).getCoverPath();
        image = new Image(path);
        setSelectedBook(books.get(rando));
        rand.setImage(image);
        last_value=rando;
        System.out.println(rando);
    }

}
