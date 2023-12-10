package com.example.libirary_;

import AdminPackage.UpdateBookFunctions;
import InterfacesPackage.CommonFunctions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class UpdateBookInfoController extends UpdateBookFunctions implements CommonFunctions {

    public void Back(ActionEvent event) throws IOException {
        BackToAdmin(event);
    }
}
