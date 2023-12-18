package librarypackage;

import UsersOfLibrary.User;
import com.example.libirary_.Book;
import userprofile.Order;

import java.io.Serializable;
import java.util.ArrayList;

public  class Library implements Serializable {
    public static ArrayList<User> users = new ArrayList<User>();
    public static ArrayList<Order> orders = new ArrayList<Order>();
    public static ArrayList<Book> books = new ArrayList<Book>();

}
