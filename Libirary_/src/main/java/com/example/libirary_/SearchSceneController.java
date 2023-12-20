package com.example.libirary_;

import InterfacesPackage.CommonFunctions;
import librarypackage.Library;
import searchengine.SearchEngine;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static librarypackage.Library.setSelectedBook;

public class SearchSceneController extends SearchEngine implements Initializable, CommonFunctions {
    @FXML
    private TextField searchBar;
    @FXML
    private ListView<String> listView;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        super.uploadAllBooks();
        listView.getItems().addAll(words);
        // do event when click on any word
        try {
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                String selectedWord = listView.getSelectionModel().getSelectedItem();
                setSelectedBook(findBook(selectedWord));
                try {
                    switchToBookDetailsScene(searchBar);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        }catch (NullPointerException ex){
        System.out.println(ex);
        }
    }

    @FXML//when click on search button
    void search(ActionEvent event) {
        listView.getItems().clear();
        listView.getItems().addAll(super.searchList(searchBar.getText(),words));
    }
    @FXML
    void BackToHomePage(ActionEvent event) throws IOException {
        SwitchToNextScene(event,"HomePage.fxml");

    }

    void switchToBookDetailsScene(Node node) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BookDetails.fxml"));
        Stage stage = (Stage) (node).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }
}