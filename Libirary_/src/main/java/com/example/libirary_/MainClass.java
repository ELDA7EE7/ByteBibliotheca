package com.example.libirary_;

import FileHandlingPackage.FileHandling;
import UsersOfLibrary.Person;
import datastructure.trie.Trie;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import librarypackage.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


import static UsersOfLibrary.User.incrementUsersCounter;
import static librarypackage.Library.*;
import static resourcesimports.UserInterfaceIcons.ProgramIcon;

public class MainClass extends Application  {
    public static Trie namesTrie =new Trie(), emailsTrie =new Trie(),booksTrie =new Trie();
    static {
        try {
            // upload data from files here
           FileHandling.loadData();

            // add default user
            //Person user = new User("mazenalaa","mazen@gmail.com","123456789a");
            for (Person p : users) {
                incrementUsersCounter();
                namesTrie.insert(p.getName());
                emailsTrie.insert(p.getEmail());
            }
            for(Book b :books){
                booksTrie.insert(b.getTitle());
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(MainClass.class.getResource("SplashScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("ByteBibliotheca");
        stage.initStyle(StageStyle.UNDECORATED);
        stage.getIcons().add(ProgramIcon);
        stage.setScene(scene);
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
        alert.setHeaderText("You're about to close ByteBibliotheca!");
        alert.setContentText("Do you want to save before exiting?");

        if (alert.showAndWait().get() == ButtonType.OK){
           // System.out.println("You successfully logged out");
           FileHandling.saveData();
            stage.close();
        }
    }
    public static void main(String[] args) throws IOException {
        launch();
    }
}