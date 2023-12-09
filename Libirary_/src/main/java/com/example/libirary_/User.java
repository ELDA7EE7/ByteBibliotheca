package com.example.libirary_;

import java.util.ArrayList;

public class User {
    static int userCounter =0;
    UserInformation userInfo;
    static User CurrentUser;
   static ArrayList<User> users = new ArrayList<User>();

    public User(String userName, String email, String password) {
        userCounter++;
        this.userInfo = new UserInformation(userCounter+200,userName,email,password);
        users.add(this);
    }

    public String getEmailInfo() {
        return userInfo.getEmail();
    }
    public String getPasswordInfo() {
        return userInfo.getPassword();
    }
    public String getUsernameInfo() {
        return userInfo.getUserName();
    }

    public void setEmailInfo(String email) {
        this.userInfo.email = email;
    }
    public void setPasswordInfo(String password) {
        this.userInfo.password = password;
    }
    public void setUserNameInfo(String userName) {
        this.userInfo.userName = userName;
    }


    public static int getUserCounter() {
        return userCounter;
    }
}
