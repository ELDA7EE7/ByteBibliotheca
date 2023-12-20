package com.example.libirary_;

import AdminPackage.AddBookFunctions;
import InterfacesPackage.CommonFunctions;
import javafx.event.ActionEvent;

import java.io.IOException;

public class AddBookSceneController extends AddBookFunctions implements CommonFunctions {
    public void Back(ActionEvent event) throws IOException {
        SwitchToNextScene(event,"AdminHomePage.fxml");
    }
}
