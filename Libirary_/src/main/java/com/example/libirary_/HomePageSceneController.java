package com.example.libirary_;

import InterfacesPackage.CommonFunctions;
import javafx.event.ActionEvent;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePageSceneController extends SearchSceneController implements Initializable , CommonFunctions
{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private AnchorPane platform;
    @FXML
    private ImageView bookimage1=new ImageView(),bookimage2=new ImageView(),bookimage3=new ImageView(),
            bookimage4=new ImageView(),bookimage5=new ImageView()
            ,bookimage6=new ImageView(),bookimage7=new ImageView(),bookimage8=new ImageView(),bookimage9=new ImageView()
            ,bookimage10=new ImageView(), bookimage11=new ImageView(),bookimage12=new ImageView(),bookimage13=new ImageView()
            ,bookimage14=new ImageView(),bookimage15=new ImageView();


    @FXML
    private Label bookname1 =new Label(),bookname2 =new Label(),bookname3 =new Label(),bookname4 =new Label(),bookname5
            ,bookname6,bookname7,bookname8,bookname9,bookname10,
            bookname11,bookname12,bookname13,bookname14,bookname15;

    //@FXML
    void SwitchToSearchScene(ActionEvent e) throws IOException{
        root= FXMLLoader.load(getClass().getResource("SearchScene.fxml"));
        stage=(Stage) ((Node) e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void SwitchToUserProfileScene(ActionEvent e) throws IOException{
        SwitchToNextScene(e,"UserProfileScene.fxml");
    }

    public void cart(MouseEvent e) throws IOException { //Change Scene to Cart Page
        SwitchToNextScene(e,"ShoppingCart.fxml");

    }
    public void BookDetails(MouseEvent e) throws IOException {//Change Scene to BookDetails Page
        String id=e.getPickResult().getIntersectedNode().getId();
        BookDetails bookDetails=new BookDetails();
        bookDetails.setId(id);
        SwitchToNextScene(e,"BookDetails.fxml");

    }

    private Image image;
    @FXML
    private ImageView rand;
    public void random(ActionEvent e) throws IOException{
        image=new Image(getClass().getResource("Cart.png").toExternalForm());//show image for random book
        rand.setImage(image);
    }

    public void CategoriesPage(ActionEvent e) throws IOException {//Change Scene to Categories Page

        SwitchToNextScene(e,"Categories.fxml");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        super.initialize(url,resourceBundle);
        Book book =new Book("Rich Dad Poor Dad","Ehab","Valid",2000,500,
                "HUmanDevelopment", "/RichDadPoorDad.jpg",true,4,10,"bookimage62");

        book =new Book("Atomic habit","Ehab","Valid",2000,500,
                "HUmanDevelopment", "/atomic.jpg",true,4,10,"bookimage72");

        book =new Book("Rich Dad  Dad","Ehab","Valid",2000,500,
                "HUmanDevelopment", "/RichDadPoorDad.jpg",true,3,10,"");




        Image  imagebook =new Image(Book.books.get(0).getImagepath());
         bookimage1.setImage(imagebook);
        bookname1.setText(Book.books.get(0).getTitle());

        imagebook =new Image(Book.books.get(1).getImagepath());
        bookimage2.setImage(imagebook);
        bookname2.setText(Book.books.get(1).getTitle());

        imagebook =new Image(Book.books.get(2).getImagepath());
        bookimage3.setImage(imagebook);
        bookname3.setText(Book.books.get(2).getTitle());


    }
}
