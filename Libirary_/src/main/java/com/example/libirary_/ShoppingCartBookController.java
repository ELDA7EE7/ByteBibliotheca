package com.example.libirary_;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ShoppingCartBookController implements Initializable {

    @FXML
    private Label author;

    @FXML
    private Label bookName;

    @FXML
    private Button deleteBook;

    @FXML
    private Label genre;

    @FXML
    private Label price;

    @FXML
    private Label quantity;

    @FXML
    private Spinner<Integer> quantitySlider;

    @FXML
    private Label rating;

    @FXML
    private Label totalPrice;
    private VBox shoppingCartBooksList;

    @FXML
    public void deleteBookClicked(ActionEvent event) {
        HBox parentContainer = (HBox) deleteBook.getParent().getParent();
        shoppingCartBooksList.getChildren().remove(parentContainer);
    }
    public void setData(Book book, VBox shoppingCartBooksList){
        this.shoppingCartBooksList = shoppingCartBooksList;
        bookName.setText(book.getTitle());
        author.setText(book.getAuthor());
        genre.setText(book.getGenre());
        rating.setText(Float.toString(book.getRating()));
        price.setText(Float.toString(book.getPrice()));
        quantitySlider.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,book.getBookAmountAvailable(),1));
        //quantity.setText(Integer.toString(quantitySlider.getValue()));
        quantitySlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            quantity.setText(Integer.toString(newValue));
            book.setBookCounterInShoppingCart(newValue);
            book.calculateBookPrice();
            totalPrice.setText(Float.toString(book.getTotalPriceInShoppingCart()));
        });
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
