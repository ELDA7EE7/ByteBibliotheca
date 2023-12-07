package com.example.libirary_;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
public class Book {
    private static int bookCounter=0;
    private int bookID,
    publishYear;
    private String title;
    private String author;
    private String status;

    private String imagepath;
    private float price;
    private String Genre;
    static ArrayList<Book> books = new ArrayList<Book>();
    private Image image;
    private ImageView view;

    public Book(String title, String author, String status, int publishYear, float price, String genre, String path){
        this.title = title;
        this.author = author;
        this.status = status;
        this.publishYear = publishYear;
        this.price = price;
        this.Genre=genre;
        this.image =new Image(path);
        this.imagepath=path;

        bookCounter++;
        bookID=bookCounter;
        books.add(this);
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
        author = author;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        status = status;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setImageview(Image image)
    {
        this.view.setImage(image);
    }

    public Image getImage() {  return image; }

    public String getImagepath() { return imagepath; }

    public void setImagepath(String imagepath) {  this.imagepath = imagepath; }

    public ImageView getView() {  return view; }

    public void setView(ImageView view) { this.view = view;}
}
