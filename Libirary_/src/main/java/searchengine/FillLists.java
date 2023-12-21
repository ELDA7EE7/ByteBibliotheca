package searchengine;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import librarypackage.Book;

import java.util.ArrayList;

import static librarypackage.Library.books;

public abstract class FillLists {
    @FXML
    public ListView<String> authorList,availableList;
    @FXML
    public Label authorName, listLabel;

    private void fillWordWithOnlyAvailableBooks(ArrayList<String>words){
        for(Book b :books){
             if(b.isAvailable())
                 words.add(b.getTitle());
        }
    }
    protected void uploadAvailableBooks(){
        ArrayList<String>words=new ArrayList<>();
        fillWordWithOnlyAvailableBooks(words);
    try{
         availableList.getItems().addAll(words);
    }catch (NullPointerException ex){
      System.out.println("NO available books");
    }
    }

    protected void uploadAuthorBooks(String author){
        ArrayList<String>words=new ArrayList<>();
        fillWordWithOnlyAuthorBooks(words,author);
        authorName.setText(author);
        try{
            authorList.getItems().clear();
            authorList.getItems().addAll(words);
        }catch (NullPointerException ex){
            System.out.println("NO available books");
        }
    }
    private void fillWordWithOnlyAuthorBooks(ArrayList<String>words,String author){
        for(Book b :books){
            if(b.getAuthor().equals(author))
                words.add(b.getTitle());
        }
    }



}
