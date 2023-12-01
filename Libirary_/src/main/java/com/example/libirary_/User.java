package com.example.libirary_;

public class User {
    static int userCounter =0;
    final int userID;
    String userName;
    String email;
    String password;

    public User(String userName, String email, String password) {
        userCounter++;
        this.userID = userCounter+200;
        this.userName = userName;
        this.email = email;
        this.password = password;
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
