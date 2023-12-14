package com.example.libirary_;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
public class Book {
    private static int bookCounter=0;
    private int bookCounterInShoppingCart;
    private int bookID;
    private int publishYear;
    private int bookAmountAvailable;
    private String title;
    private String author;
    private String status;

    private String imagepath;
    private float price;
    private String Genre;
    public static ArrayList<Book> books = new ArrayList<Book>();
    private Image image;
    private ImageView view;
    private boolean IsAvailable;
    private int ExpiryDate;
    private float totalPriceInShoppingCart;

    public Book(String title, String author, String status, int publishYear, float price, String genre, String path, boolean IsAvailable,int bookAmountAvailable, int expiryDate) {
        this.title = title;
        this.author = author;
        this.status = status;
        bookCounterInShoppingCart = 0;
        this.publishYear = publishYear;
        this.price = price;
        this.Genre = genre;
        this.image = new Image(path);
        this.imagepath = path;
        this.IsAvailable = IsAvailable;
        this.bookAmountAvailable = bookAmountAvailable;
        bookCounter++;
        bookID = bookCounter;
        books.add(this);
        this.ExpiryDate = expiryDate;
        totalPriceInShoppingCart = 0;
    }
    public Book(String title, String author, String status, int publishYear, float price, String genre, String path) {
        this.title = title;
        this.author = author;
        this.status = status;
        this.publishYear = publishYear;
        this.price = price;
        this.Genre = genre;
        this.image = new Image(path);
        this.imagepath = path;
    }
    public int getBookCounterInShoppingCart() {
        return bookCounterInShoppingCart;
    }

    public void setBookCounterInShoppingCart(int bookCounterInShoppingCart) {
        this.bookCounterInShoppingCart = bookCounterInShoppingCart;
    }
    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setImageview(Image image) {
        this.view.setImage(image);
    }

    public Image getImage() {
        return image;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public ImageView getView() {
        return view;
    }

    public void setView(ImageView view) {
        this.view = view;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

        public boolean isAvailable() {
            return IsAvailable;
        }

        public void setAvailable (boolean available){
            IsAvailable = available;
        }

        public int getExpiryDate () {
            return ExpiryDate;
        }

        public void setExpiryDate (int expiryDate){
            ExpiryDate = expiryDate;

        }

    public int getBookAmountAvailable() {
        return bookAmountAvailable;
    }

    public void setBookAmountAvailable(int bookAmountAvailable) {
        this.bookAmountAvailable = bookAmountAvailable;
    }

    public float getTotalPriceInShoppingCart() {
        return totalPriceInShoppingCart;
    }

    public void setTotalPriceInShoppingCart(float totalPriceInShoppingCart) {
        this.totalPriceInShoppingCart = totalPriceInShoppingCart;
    }
}

