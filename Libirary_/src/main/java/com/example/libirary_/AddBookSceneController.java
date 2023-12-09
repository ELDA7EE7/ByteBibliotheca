package com.example.libirary_;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddBookSceneController implements CommonFunctions {
    @FXML
    private TextField nameTextField,authorTextField,genreTextField,publishyearTextField,imagepathTextField,priceTextField;
    @FXML
    private CheckBox statusCheckBox;
    @FXML
    private Label successLabel;
    public void  CheckIfInputIsValid(){
        try {
            if(nameTextField.getText().isEmpty()
                    ||authorTextField.getText().isEmpty()
                    ||genreTextField.getText().isEmpty()
                    ||publishyearTextField.getText().isEmpty()
                    || imagepathTextField.getText().isEmpty()
                    ||priceTextField.getText().isEmpty()){
                showAlert("Please Enter all the data");
                successLabel.setText("");
                return;
            }
        }catch (Exception e){
            showAlert("An error happened");
            System.out.println(e.getMessage());
        }


    }
    public void GetData(){
        String name = nameTextField.getText()
                ,author =authorTextField.getText()
                ,genre= genreTextField.getText()
                ,imagepath=imagepathTextField.getText(),status;
        int publishyear=Integer.parseInt(publishyearTextField.getText());
        float price=Float.parseFloat(priceTextField.getText());
        if(statusCheckBox.isSelected()){
            status="In Stock";
        }
        else {
            status = "Out of Stock";
        }
        successLabel.setText("Book added successfully");
        Book newBook = new Book(name,author,status,publishyear,price,genre,imagepath);
        System.out.println(Book.books.size());
    }
    public void AddBook(ActionEvent event){
        CheckIfInputIsValid();
        GetData();
    }
}
