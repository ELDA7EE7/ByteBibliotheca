package com.example.libirary_;

import javafx.scene.control.TextField;

import java.io.IOException;

public class Admin extends UpdateBookInfoController {
    private String email="admin",password="admin";

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    public void AddBook(String title,String author,String status,int publishYear,float price,String genre){
        Book newBook = new Book(title,author,status,publishYear,price,genre,"berserk1.jpg");
    }
    public void RemoveBook(int bookID){
        Book.books.remove(bookID);
    }

    public void UpdateBookInfo(int bookID) throws IOException {
        Book updateBook = Book.books.get(bookID-1);

        updateBook.setAuthor(/*updateAuthor.getText()*/"mazen2");
        updateBook.setPrice(/*Float.parseFloat(updatePrice.getText())*/500.0F);
        updateBook.setStatus(Update_Available.getText());
        System.out.println("1");
    }
}
