package com.example.libirary_;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        stage.setScene(scene);

        stage.show();

    }

    public void cart(ActionEvent e) throws IOException {
        root= FXMLLoader.load(getClass().getResource("CartScene.fxml"));
        stage=(Stage) ((Node) e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


}
