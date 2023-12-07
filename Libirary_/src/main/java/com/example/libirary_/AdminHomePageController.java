package com.example.libirary_;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminHomePageController {
  private   Stage stage;
  private Parent root;
   private Scene scene;
    @FXML
    Button updateBookInfoButton;

    @FXML
    public void switchToUpdateBookInfoPageScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("UpdateBookInfo.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }
}
