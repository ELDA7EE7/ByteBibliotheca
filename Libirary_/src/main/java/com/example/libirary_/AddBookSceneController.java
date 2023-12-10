package com.example.libirary_;

import AdminPackage.AddBookFunctions;
import AdminPackage.AdminFunctionalities;
import InterfacesPackage.CommonFunctions;
import com.example.libirary_.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddBookSceneController extends AddBookFunctions implements CommonFunctions {
    public void Back(ActionEvent event) throws IOException {
        BackToAdmin(event);
    }
}
