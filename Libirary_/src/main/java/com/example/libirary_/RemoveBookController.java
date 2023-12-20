package com.example.libirary_;

import AdminPackage.RemoveBookFunctions;
import InterfacesPackage.CommonFunctions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class RemoveBookController extends RemoveBookFunctions implements CommonFunctions {




    public void BackToAdmin(ActionEvent event) throws IOException {
        SwitchToNextScene(event,"AdminHomePage.fxml");//return to AdminHomePage
    }
}
