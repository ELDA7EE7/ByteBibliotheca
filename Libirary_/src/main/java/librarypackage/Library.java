package librarypackage;

import UsersOfLibrary.User;
import userprofile.Order;

import java.io.Serializable;
import java.util.ArrayList;

public  class Library implements Serializable {
    public static ArrayList<User> users = new ArrayList<User>();
    public static ArrayList<Order> orders = new ArrayList<Order>();

    public static ArrayList<Book> books = new ArrayList<Book>();
    private static Book selectedBook;

    public static Book getBook() {
        return selectedBook;
    }

    public static void setBook(Book book) {
        Library.selectedBook = book;
    }
}
