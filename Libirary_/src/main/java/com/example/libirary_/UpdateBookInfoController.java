package com.example.libirary_;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.io.IOException;

public class UpdateBookInfoController implements CommonFunctions {
    @FXML
    TextField updateAuthor,updatePrice,UpdateTitle,UpdatePublishYear,indexsearchTextField,genreTextField,authorTextField;
    @FXML
   private CheckBox statusCheckBox;

    @FXML
    private Label UpdateP,update2,Update_PublishYear,Update_Title, Update_Available,successLabel;
    int index;


    public void setUpdate2(ActionEvent e) throws IOException {
        update2.setText(updateAuthor.getText());
    }
    public void setUpdatePrice(ActionEvent e) throws IOException {
        UpdateP.setText(updatePrice.getText());
    }
    public void setUpdateAvailable(ActionEvent e) throws IOException {
        if(statusCheckBox.isSelected())
        Update_Available.setText("In stock");
        else
            Update_Available.setText("Out of stock");

    }
    public void setUpdateTitle(ActionEvent e) throws IOException {
        Update_Title.setText(UpdateTitle.getText());
    }
    public void setUpdatePublishYear(ActionEvent e) throws IOException {
        Update_PublishYear.setText(UpdatePublishYear.getText());
    }
    public void ResetAll(){
        indexsearchTextField.clear();
        authorTextField.clear();
        genreTextField.clear();
        UpdatePublishYear.clear();
        UpdateTitle.clear();
        updatePrice.clear();
        updateAuthor.clear();
        statusCheckBox.setSelected(false);
    }
    public void ShowDataInTextFeilds(){
        updateAuthor.setText(Book.books.get(index).getAuthor());
        updatePrice.setText(Float.toString(Book.books.get(index).getPrice()));
        UpdateTitle.setText(Book.books.get(index).getTitle());
        UpdatePublishYear.setText(Integer.toString(Book.books.get(index).getPublishYear()));
        genreTextField.setText(Book.books.get(index).getGenre());
        String available=new String(Book.books.get(index).getStatus());

        if (available.equalsIgnoreCase("in stock")){
            statusCheckBox.setSelected(true);
        }
        else{
            statusCheckBox.setSelected(false);

        }
    }
    public void ViewBookToUpdate(ActionEvent event){
        try {
            successLabel.setText("");
            String bookname = indexsearchTextField.getText(),bookauthor= authorTextField.getText();
            index= SearchForBookByNameAndAuthor(bookname,bookauthor);
            ShowDataInTextFeilds();
        }catch (Exception e){
            showAlert("Book not found");
            System.out.println(e.getMessage());
        }

    }
    public void SaveTheDataInTheBook(){
        //check if any text field is empty
        if(indexsearchTextField.getText().isEmpty()
                ||updateAuthor.getText().isEmpty()
                || UpdateTitle.getText().isEmpty()
                || genreTextField.getText().isEmpty()
                ||updatePrice.getText().isEmpty()
                || UpdatePublishYear.getText().isEmpty()){
            showAlert("Please Enter all the data");
            return;
        }

        Book.books.get(index).setAuthor(updateAuthor.getText());
        Book.books.get(index).setTitle(UpdateTitle.getText());
        Book.books.get(index).setGenre(genreTextField.getText());
        Book.books.get(index).setPrice(Float.parseFloat(updatePrice.getText()));
        Book.books.get(index).setPublishYear(Integer.parseInt(UpdatePublishYear.getText()));
        if(statusCheckBox.isSelected()){
            Book.books.get(index).setStatus("In stock");
        }
        else{
            Book.books.get(index).setStatus("Out of stock");
        }

        successLabel.setText("Book Updated Successfully");
    }
    public void PrintStuffForDebugging(){
        System.out.println(Book.books.get(index).getBookID());
        System.out.println(Book.books.get(index).getGenre());
        System.out.println(Book.books.get(index).getAuthor());
        System.out.println(Book.books.get(index).getPrice());
        System.out.println(Book.books.get(index).getPublishYear());
        System.out.println(Book.books.get(index).getTitle());
        System.out.println(Book.books.get(index).getStatus());
        System.out.println(Book.books.size());
    }
    public void UpdateBookInfo(ActionEvent event) {
        try{

            SaveTheDataInTheBook();
            ResetAll();
            PrintStuffForDebugging();
        }catch(Exception e){
          showAlert("Please Enter all the data");
            System.out.println(e.getMessage());
        }
    }
}
