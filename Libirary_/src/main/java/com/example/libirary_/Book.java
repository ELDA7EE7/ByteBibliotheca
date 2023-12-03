package com.example.libirary_;
import java.util.ArrayList;
public class Book {
    private static int bookCounter=0;
    private int bookID,
    publishYear;
    private String title,
            author,
            status;
    private float price;
    static ArrayList<Book> books = new ArrayList<Book>();
    public Book(String title,String author,String status,int publishYear,float price){
        this.title = title;
        this.author = author;
        this.status = status;
        this.publishYear = publishYear;
        this.price = price;
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
}
