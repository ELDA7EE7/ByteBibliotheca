package com.example.libirary_;
import AdminPackage.AdminFunctionalities;
import InterfacesPackage.CommonFunctions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
public class AdminHomePageController extends AdminFunctionalities implements CommonFunctions {
  private   Stage stage;
  private Parent root;
   private Scene scene;
    @FXML
    public void switchToUpdateBookInfoPageScene(ActionEvent event) throws IOException { //Change Scene to Update Book Info Page
        root = FXMLLoader.load(getClass().getResource("UpdateBookInfo.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }

    @FXML
    public void switchToRemoveBook(ActionEvent event) throws IOException { //Change Scene to Remove Book Page
        root = FXMLLoader.load(getClass().getResource("RemoveBook.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }
    @FXML
    public void SwitchToAddBookScene(ActionEvent event) throws IOException { // Change Scene to Add Book Page
        root = FXMLLoader.load(getClass().getResource("AddBookScene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }
}

