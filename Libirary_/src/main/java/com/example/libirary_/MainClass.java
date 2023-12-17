package com.example.libirary_;

import datastructure.trie.Trie;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

import static librarypackage.Library.users;

public class MainClass extends Application {

    public static Trie names=new Trie(),emails=new Trie();
    static {

        // upload data from files here


        // add default user
        Person user = new User("mazenalaa","mazen@gmail.com","12345678a");
        for (Person p : users ) {
            names.insert(p.getName());
            emails.insert(p.getEmail());
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
            close(stage);
        });
    }
    public void close(Stage stage){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Close");
        alert.setHeaderText("You're about to Close Programme!");
        alert.setContentText("Do you want to save before exiting?");

        if (alert.showAndWait().get() == ButtonType.OK){
           // System.out.println("You successfully logged out");
            stage.close();
        }
    }
    public static void main(String[] args) throws IOException {


        launch();
    }
}