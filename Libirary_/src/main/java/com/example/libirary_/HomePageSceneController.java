package com.example.libirary_;

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
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageSceneController
{
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void RandomBookGen(ActionEvent e) throws IOException {
        root= FXMLLoader.load(getClass().getResource("RandomPage.fxml"));
        stage=(Stage) ((Node) e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setFullScreen(true);
        stage.setScene(scene);

        stage.show();

    }

    public void cart(MouseEvent e) throws IOException {
        root= FXMLLoader.load(getClass().getResource("CartScene.fxml"));
        stage=(Stage) ((Node) e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();

    }
    public void BookDetails(MouseEvent e) throws IOException{
        root= FXMLLoader.load(getClass().getResource("BookDetails.fxml"));
        stage=(Stage) ((Node) e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();



    }

    private Image image;
    @FXML
    private ImageView rand;
    public void random(ActionEvent e) throws IOException{
        image=new Image(getClass().getResource("Cart.png").toExternalForm());
        rand.setImage(image);

    }

    public void CategoriesPage(ActionEvent e) throws IOException {
        root= FXMLLoader.load(getClass().getResource("Categories.fxml"));
        stage=(Stage) ((Node) e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();

    }

}
