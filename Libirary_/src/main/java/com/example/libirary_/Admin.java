package com.example.libirary_;

public class Admin {
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
        Book newBook = new Book(title,author,status,publishYear,price,genre,"berserk1.jpg",true,4,10);
    }
    public void RemoveBook(int bookID){
        Book.books.remove(bookID);
    }
    public void UpdateBookInfo(int bookID){
      Book updateBook = Book.books.get(bookID-1);


    }

}
