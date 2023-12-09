package com.example.libirary_;

import javafx.scene.control.TextField;

import java.io.IOException;

public class Admin{
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



}
