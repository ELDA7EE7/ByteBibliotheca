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
    private TextField updateAuthor,updatePrice,UpdateTitle,UpdatePublishYear,indexsearchTextField,genreTextField;
    @FXML
   private RadioButton UpdateAvailable;

    @FXML
    private Label UpdateP,update2,Update_PublishYear,Update_Title, Update_Available;

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
    public void ViewBookToUpdate(ActionEvent event){
        try {
            int index = Integer.parseInt(indexsearchTextField.getText()) - 1;
          updateAuthor.setText(Book.books.get(index).getAuthor());
            updatePrice.setText(Float.toString(Book.books.get(index).getPrice()));
            UpdateTitle.setText(Book.books.get(index).getTitle());
            UpdatePublishYear.setText(Integer.toString(Book.books.get(index).getPublishYear()));
            genreTextField.setText(Book.books.get(index).getGenre());
          String avilable=new String(Book.books.get(index).getStatus());
          //jada
          if (avilable.equalsIgnoreCase("in stock")){
              UpdateAvailable.setSelected(true);
          }
          else{
              UpdateAvailable.setSelected(false);

          }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
   // public void UpdateBookInfo(int bookID)  {
     //   Book updateBook = Book.books.get(bookID-1);

       // updateBook.setAuthor(updateAuthor.getText());
        //updateBook.setPrice(Float.parseFloat(updatePrice.getText()));
        //updateBook.setStatus(Update_Available.getText());
        //updateBook.setTitle(UpdateTitle.getText());
        //updateBook.setPublishYear(Integer.parseInt(UpdatePublishYear.getText()));

    //}

    public void UpdateBookInfo(ActionEvent event) {

    }
}
