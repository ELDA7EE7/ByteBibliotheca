package com.example.libirary_;

import FileHandlingPackage.FileHandling;
import UsersOfLibrary.Person;
import datastructure.trie.Trie;
import UsersOfLibrary.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import librarypackage.Book;
import userprofile.Order;

import java.io.*;
import java.util.ArrayList;

import static librarypackage.Library.*;

public class MainClass extends Application  {
    public static Trie names=new Trie(),emails=new Trie();
    static {
        try {
            // upload data from files here
           FileHandling.loadData();

            // add default user
            //Person user = new User("mazenalaa","mazen@gmail.com","123456789a");
            for (Person p : users) {
                names.insert(p.getName());
                emails.insert(p.getEmail());
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(MainClass.class.getResource("SplashScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Library");
        stage.setScene(scene);
        //stage.setFullScreen(true);
        stage.show();
        stage.setOnCloseRequest(event -> {
            event.consume();
            try {
                close(stage);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        });
    }


    public void close(Stage stage) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Close");
        alert.setHeaderText("You're about to Close Programme!");
        alert.setContentText("Do you want to save before exiting?");

        if (alert.showAndWait().get() == ButtonType.OK){
           // System.out.println("You successfully logged out");
           FileHandling.saveData();
            stage.close();
        }
    }
    public static void main(String[] args) throws IOException {
      //  Book b=new Book("Iron Flame","Rebecca Yarros","Everyone Expected Violet Sorrengail To Die During Her First Year At Basgiath War College—Violet Included. But Threshing Was Only The First Impossible Test Meant To Weed Out The Weak-Willed, The Unworthy, And The Unlucky. Now The Real Training Begins, And Violet’s Already Wondering How She’ll Get Through. It’s Not Just That It’s Grueling And Maliciously Brutal, Or Even That It’s Designed To Stretch The Riders’ Capacity For Pain Beyond Endurance. It’s The New Vice Commandant, Who’s Made It His Personal Mission To Teach Violet Exactly How Powerless She Is–Unless She Betrays The Man She Loves. Although Violet’s Body Might Be Weaker And Frailer Than Everyone Else’s, She Still Has Her Wits—And A Will Of Iron. And Leadership Is Forgetting The Most Important Lesson Basgiath Has Taught Her: Dragon Riders Make Their Own Rules.","In Stock",2023,4.7F,190.0F,"Fantasy","IronFlame.png",true,2,5);
      //books.add(b);

        launch();
    }
    // save orders needs to be checked
    // search engine has errors
    // save of borrowers and purchase
}