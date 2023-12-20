package com.example.libirary_;

import searchengine.FillLists;
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
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.example.libirary_.MainClass.booksTrie;
import static librarypackage.Library.setSelectedBook;

public class SearchSceneController extends FillLists implements SearchEngine , Initializable  {

    protected ArrayList<String> words = new ArrayList<>();
    @FXML
    private TextField searchBar;
    @FXML
    private ListView<String> searchListView;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        uploadAllBooks(words);
        searchListView.getItems().addAll(words);
        uploadAvailableBooks();
        // do event when click on any word
        try {
        searchListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                String selectedWord = searchListView.getSelectionModel().getSelectedItem();
                if(booksTrie.search(selectedWord)) {
                    setSelectedBook(findBook(selectedWord));
                    try {
                        switchToBookDetailsScene(searchBar);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
               else
                    uploadAuthorBooks(selectedWord);

            }
        });
        }catch (NullPointerException ex){
        System.out.println(ex);
        }

        try {
            availableList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                    String selectedWord = availableList.getSelectionModel().getSelectedItem();
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

        try {
            authorList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                    String selectedWord = authorList.getSelectionModel().getSelectedItem();
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
        searchListView.getItems().clear();
        searchListView.getItems().addAll(searchList(searchBar.getText(),words));
    }
    @FXML
    void BackToHomePage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
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