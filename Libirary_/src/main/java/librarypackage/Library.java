package librarypackage;

import UsersOfLibrary.Borrower;
import UsersOfLibrary.User;
import userprofile.Order;

import java.io.Serializable;
import java.util.ArrayList;

public  class Library implements Serializable {
    public static ArrayList<User> users = new ArrayList<User>();
    public static ArrayList<Order> orders = new ArrayList<Order>();

    public static ArrayList<Book> books = new ArrayList<Book>();
    public static ArrayList<Transaction> transactions = new ArrayList<>();
    public static ArrayList<Borrower> borrowers = new ArrayList<>();
    private static Book selectedBook;

    public static Book getSelectedBook() {
        return selectedBook;
    }

    public static void setSelectedBook(Book book) {
        Library.selectedBook = book;
    }
}
