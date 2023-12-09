package com.example.libirary_;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public interface CommonFunctions {


    default void BackToAdmin(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("AdminHomePage.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }
    default void showAlert(String message){
        // Alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    default int SearchForBookByNameAndAuthor(String name,String author){
        int index=Integer.MAX_VALUE;
        for (int i=0;i<Book.books.size();i++){
            if (Book.books.get(i).getTitle().equalsIgnoreCase(name)&&Book.books.get(i).getAuthor().equalsIgnoreCase(author) ){
                index= i;
            }
        }
        return index;
    }

}
