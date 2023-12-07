package com.example.libirary_;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class UpdateBookInfoController {
    @FXML
    TextField updateAuthor,updatePrice,UpdateTitle,UpdatePublishYear;
    @FXML
    RadioButton UpdateAvailable;

    @FXML
    private Label UpdateP,update2,Update_PublishYear,Update_Title;
    protected Label Update_Available;

    public void setUpdate2(ActionEvent e) throws IOException {
        update2.setText(updateAuthor.getText());
    }
    public void setUpdatePrice(ActionEvent e) throws IOException {
        UpdateP.setText(updatePrice.getText());
    }
    public void setUpdateAvailable(ActionEvent e) throws IOException {
        if(UpdateAvailable.isSelected()==true)
        Update_Available.setText("In stock");
        else
            Update_Available.setText("Out stock");

    }
    public void setUpdateTitle(ActionEvent e) throws IOException {
        Update_Title.setText(UpdateTitle.getText());
    }
    public void setUpdatePublishYear(ActionEvent e) throws IOException {
        Update_PublishYear.setText(UpdatePublishYear.getText());
    }


}
