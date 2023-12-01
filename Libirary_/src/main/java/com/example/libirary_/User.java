package com.example.libirary_;

import java.util.ArrayList;

public class User {
    static int userCounter =0;
    final int userID;
    String userName;
    String email;
    String password;
    static ArrayList<User> users = new ArrayList<User>();
    public User(String userName, String email, String password) {
        userCounter++;
        this.userID = userCounter+200;
        this.userName = userName;
        this.email = email;
        this.password = password;
        users.add(this);
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getUserID() {
        return userID;
    }

    public static int getUserCounter() {
        return userCounter;
    }
}
