package com.example.libirary_;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import librarypackage.Book;
import shoppingcart.ShoppingCart;

public class ShoppingCartBookController{

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
    private ShoppingCart shoppingCart;

    @FXML
    public void deleteBookClicked(ActionEvent event) {
        HBox parentContainer = (HBox) deleteBook.getParent().getParent();
        shoppingCartBooksList.getChildren().remove(parentContainer);
        Book bookToRemove = (Book)parentContainer.getUserData();
        shoppingCart.removeBook(bookToRemove);
        shoppingCart.calculateTotalPrice();
    }
    public void setData(Book book, VBox shoppingCartBooksList, ShoppingCart shoppingCart, Label totalBooksPrice){
        this.shoppingCart = shoppingCart;
        this.shoppingCartBooksList = shoppingCartBooksList;
        HBox parentContainer = (HBox) bookName.getParent();
        parentContainer.setUserData(book);
        bookName.setText(book.getTitle());
        author.setText(book.getAuthor());
        genre.setText(book.getGenre());
        rating.setText(Float.toString(book.getRating()));
        price.setText(Float.toString(book.getPrice()));
        quantitySlider.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,book.getBookAmountAvailable(),1));
        quantitySlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            shoppingCart.updateQuantity(book,newValue);
            quantity.setText(Integer.toString(newValue));
            book.setBookCounterInShoppingCart(newValue);
            book.calculateBookPrice();
            shoppingCart.calculateTotalPrice();
            totalPrice.setText(Float.toString(book.getTotalPriceInShoppingCart()));
            totalBooksPrice.setText(shoppingCart.getTotalPrice()+ " LE");
        });
    }
}
