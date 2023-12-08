package com.example.libirary_;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class RemoveBookController implements CommonFunctions {



   @FXML
    private Label RemoveAuthor,RemovePrice,RemoveTitle,RemovePublishYear,RemoveGenre,RemoveAvailable,Success;
   @FXML
   private TextField RemoveTextField;
   @FXML
   private ImageView RemoveImage;
   private Image image;
   public void ViewBookToRemove(ActionEvent event){
       try {
           int index = Integer.parseInt(RemoveTextField.getText()) - 1;
           RemoveAuthor.setText(Book.books.get(index).getAuthor()); //show Book Author
           RemovePrice.setText(Float.toString(Book.books.get(index).getPrice()));//show Book Price
           RemoveTitle.setText(Book.books.get(index).getTitle());//show Book Title
           RemovePublishYear.setText(Integer.toString(Book.books.get(index).getPublishYear()));//show Book PublishYear
           RemoveGenre.setText(Book.books.get(index).getGenre());//show Book Genre

           String avilable=new String(Book.books.get(index).getStatus());
           //jada
           if (avilable.equalsIgnoreCase("in stock")){//show Book status
               RemoveAvailable.setText("in stock");
           }
           else{
               RemoveAvailable.setText("out stock");

           }
           image=new Image(Book.books.get(index).getImagepath());
           RemoveImage.setImage(image); //show book image

       }catch (Exception e){
           System.out.println(e.getMessage());
           Success.setText("Wrong BookId");

       }

   }
   public void DeleteBook(ActionEvent e){
       try{
       Book.books.remove(Integer.parseInt(RemoveTextField.getText()) - 1);//Remove book from arraylist
           Success.setText("Book deleted successfully");
           RemoveTextField.setText("");
   }
       catch(Exception event)
       {
           System.out.println(event.getMessage());
       }
 }
    @Override
    public void BackToAdmin(ActionEvent event) throws IOException {
        CommonFunctions.super.BackToAdmin(event); //return to AdminHomePage
    }
}
