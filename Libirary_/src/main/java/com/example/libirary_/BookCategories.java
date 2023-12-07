package com.example.libirary_;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BookCategories  {
    private Stage stage;
    private Scene scene;
    private Parent root;
   /*
    @FXML
    private AnchorPane platform;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ImageView bookimage1,bookimage2,bookimage3,bookimage4,bookimage5
            ,bookimage6,bookimage7,bookimage8,bookimage9,bookimage10,
            bookimage11,bookimage12,bookimage13,bookimage14,bookimage15;


    @FXML
    private Label bookname1,bookname2,bookname3,bookname4,bookname5
            ,bookname6,bookname7,bookname8,bookname9,bookname10,
            bookname11,bookname12,bookname13,bookname14,bookname15;

    private ImageView booksimageview[]=new ImageView[]{bookimage1,bookimage2,bookimage3,bookimage4,bookimage5
               ,bookimage6,bookimage7,bookimage8,bookimage9,bookimage10,
            bookimage11,bookimage12,bookimage13,bookimage14,bookimage15};

    private Label bookslabels[]=new Label[]{bookname1,bookname2,bookname3,bookname4,bookname5
            ,bookname6,bookname7,bookname8,bookname9,bookname10,
            bookname11,bookname12,bookname13,bookname14,bookname15};


*/
    public void BookDetails(MouseEvent e) throws IOException {
         root= FXMLLoader.load(getClass().getResource("BookDetails.fxml"));
        stage=(Stage) ((Node) e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();



    }

/*
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        Book book =new Book("Rich Dad Poor Dad","Ehab","Valid",2000,500,
                "HUmanDevelopment", "/RichDadPoorDad.jpg");


        for (int i=0;i<1;i++){
            Image  imagebook =new Image(Book.books.get(i).getImagepath());
            booksimageview[i]=new ImageView(imagebook);
            bookslabels[i]=new Label(Book.books.get(i).getTitle());
        }

        FXMLLoader fxmlLoader = new FXMLLoader(MainClass.class.getResource("Categories.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setScene(scene);
        stage.show();

    }*/
}


