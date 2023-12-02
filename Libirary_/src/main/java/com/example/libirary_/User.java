package com.example.libirary_;

import java.util.ArrayList;

public class User {
    static int userCounter =0;
    UserInformation userInfo;
   static ArrayList<User> users = new ArrayList<User>();
    public User(String userName, String email, String password) {
        userCounter++;
        this.userInfo = new UserInformation(userCounter+200,userName,email,password);
        users.add(this);
    }
    public static int getUserCounter() {
        return userCounter;
    }
}
