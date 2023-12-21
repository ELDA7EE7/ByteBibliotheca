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


public class CategoriesController {
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
    ImageView shoppingCartIcon;
    @FXML
    ImageView profileIcon;
    @FXML
    ImageView backIcon;
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

    @FXML
    void switchToUserProfile(ActionEvent e) throws IOException{
        profileIcon.setImage(profileIconOnClick);
        SwitchToNextScene(e,"UserProfile.fxml");
    }

    @FXML
    public void switchToShoppingCart(MouseEvent e) throws IOException { //Change Scene to Cart Page
        shoppingCartIcon.setImage(shoppingCartIconOnClick);
        root= FXMLLoader.load(getClass().getResource("ShoppingCart.fxml"));
        stage=(Stage) ((Node) e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();

    }
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
