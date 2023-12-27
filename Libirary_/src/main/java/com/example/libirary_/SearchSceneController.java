package com.example.libirary_;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import resourcesimports.UserInterfaceIcons;
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
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    public ImageView backIcon,profileIcon,shoppingCartIcon;
    private final Image backIconDefault = UserInterfaceIcons.goBack;
    private final Image backIconOnHover = UserInterfaceIcons.goBackOnHover;
    private final Image backIconOnClick = UserInterfaceIcons.goBackOnClick;
    private final Image profileIconDefault = UserInterfaceIcons.profile;
    private final Image profileIconOnHover = UserInterfaceIcons.profileOnHover;
    private final Image profileIconOnClick = UserInterfaceIcons.profileOnClick;
    public Image shoppingCartIconDefault = UserInterfaceIcons.shoppingCart;
    public Image shoppingCartIconOnHover = UserInterfaceIcons.shoppingCartOnHover;
    public Image shoppingCartIconOnClick = UserInterfaceIcons.shoppingCartOnClick;
    protected ArrayList<String> words = new ArrayList<>();
    @FXML
    private TextField searchBar;
    @FXML
    private ListView<String> searchListView;

    @FXML
    void switchBackIconOnHover(MouseEvent event) {
        backIcon.setImage(backIconOnHover);
    }
    @FXML
    void resetBackIcon(){
        backIcon.setImage(backIconDefault);
    }
    @FXML
    void switchProfileIconOnHover(MouseEvent event) {
        profileIcon.setImage(profileIconOnHover);
    }
    @FXML
    void resetProfileIcon(){
        profileIcon.setImage(profileIconDefault);
    }
    @FXML
    void switchShoppingCartIconToHover(){
        shoppingCartIcon.setImage(shoppingCartIconOnHover);
    }
    @FXML
    void resetShoppingCartIcon(){
        shoppingCartIcon.setImage(shoppingCartIconDefault);
    }
    @FXML
    void switchToShoppingCart(MouseEvent e) throws IOException{
        shoppingCartIcon.setImage(shoppingCartIconOnClick);
        root= FXMLLoader.load(getClass().getResource("ShoppingCart.fxml"));
        stage=(Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.getScene().setRoot(root);
        /*scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setFullScreen(true);*/
    }
    @FXML
    void switchToUserProfile(MouseEvent e) throws IOException {
        profileIcon.setImage(profileIconOnClick);
        root= FXMLLoader.load(getClass().getResource("UserProfile.fxml"));
        stage=(Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.getScene().setRoot(root);
        /*scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setFullScreen(true);*/
    }
    @FXML
    void backToHomePage(MouseEvent event) throws IOException {
        backIcon.setImage(backIconOnClick);
        root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.getScene().setRoot(root);
        /*scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setFullScreen(true);*/
    }
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

    void switchToBookDetailsScene(Node node) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BookDetails.fxml"));
        Stage stage = (Stage) (node).getScene().getWindow();
        stage.getScene().setRoot(root);
        /*scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setFullScreen(true);*/
    }
}