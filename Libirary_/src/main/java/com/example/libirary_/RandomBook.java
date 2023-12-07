package com.example.libirary_;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RandomBook
{
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void BackRandom(ActionEvent e) throws IOException {
        root= FXMLLoader.load(getClass().getResource("HomePageScene.fxml"));
        stage=(Stage) ((Node) e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();

    }



}
