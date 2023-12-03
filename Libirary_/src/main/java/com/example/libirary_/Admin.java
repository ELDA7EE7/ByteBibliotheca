package com.example.libirary_;

public class Admin {
    private String email,password="Administrator1";

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
    public void AddBook(String title,String author,String status,int publishYear,float price){
        Book newBook = new Book(title,author,status,publishYear,price);
    }
    public void RemoveBook(int bookID){
        Book.books.remove(bookID);
    }

}
