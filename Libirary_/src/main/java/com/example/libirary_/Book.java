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
    private float price;
    private String genre;
    private String coverPath;
    public static ArrayList<Book> books = new ArrayList<Book>();

    private Image cover;
    private ImageView coverView;
    private boolean isAvailable;
    private int daysTillReturn;
    private float totalPriceInShoppingCart;

    public Book(String title, String author, String status, int publishYear, float price, String genre, String coverPath, boolean isAvailable,int bookAmountAvailable, int daysTillReturn) {
        this.title = title;

        this.author = author;
        this.status = status;
        this.publishYear = publishYear;
        this.price = price;
        this.genre = genre;
        this.coverPath = coverPath;
        this.isAvailable = isAvailable;
        this.bookAmountAvailable = bookAmountAvailable;
        bookCounter++;
        bookID = bookCounter;
        books.add(this);

        this.daysTillReturn = daysTillReturn;
        totalPriceInShoppingCart = 0;
        bookCounterInShoppingCart = 0;
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



    public ImageView getCoverView() {
        return coverView;
    }

    public void setCoverView(ImageView coverView) {
        this.coverView = coverView;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable (boolean isAvailable){
        this.isAvailable = isAvailable;
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
    public Image getCover() {
        return cover;
    }

    public void setCover(Image cover) {
        this.cover = cover;
    }

    public int getDaysTillReturn() {
        return daysTillReturn;
    }

    public void setDaysTillReturn(int daysTillReturn) {
        this.daysTillReturn = daysTillReturn;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }
}

