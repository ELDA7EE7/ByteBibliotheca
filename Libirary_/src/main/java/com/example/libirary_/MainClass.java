package com.example.libirary_;

import datastructure.trie.Trie;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import userprofile.Order;

import java.io.*;
import java.util.ArrayList;

import static librarypackage.Library.*;

public class MainClass extends Application  {

    public static Trie names=new Trie(),emails=new Trie();
    static {
        try {
            // upload data from files here
           loadData();

            // add default user
            //Person user = new User("mazenalaa","mazen@gmail.com","12345678a");
            for (Person p : users) {
                names.insert(p.getName());
                emails.insert(p.getEmail());
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }



    public static void loadUsers(){
        try{
            File loaduserFile = new File("Users.txt");
            FileInputStream userFIS= new FileInputStream(loaduserFile);
            ObjectInputStream userOIS = new ObjectInputStream(userFIS);
            users =(ArrayList<User>) userOIS.readObject();
            System.out.println(users.size());
            for(User user : users){
                System.out.println(user);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void loadBooks(){
        try{
            File loadbookFile = new File("Books.txt");
            FileInputStream bookFIS= new FileInputStream(loadbookFile);
            ObjectInputStream bookOIS = new ObjectInputStream(bookFIS);
            books =(ArrayList<Book>) bookOIS.readObject();
            System.out.println(books.size());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void loadOrders(){
        try{
            File loadOrderFile = new File("Orders.txt");
            FileInputStream orderFIS= new FileInputStream(loadOrderFile);
            ObjectInputStream orderOIS = new ObjectInputStream(orderFIS);
            orders =(ArrayList<Order>) orderOIS.readObject();
            System.out.println(orders.size());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void loadData(){
        loadUsers();
        loadBooks();
        loadOrders();
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
    public void saveUsers() throws IOException {
        try {
           // System.out.println(users.size());
            File saveusersFile = new File("Users.txt");
            FileOutputStream userFOS = new FileOutputStream(saveusersFile);
            ObjectOutputStream userOOS = new ObjectOutputStream(userFOS);
            userOOS.writeObject(users);
            userOOS.flush();
            userOOS.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void saveBooks() {
        try{
            File savebookFile = new File ("Books.txt");
            FileOutputStream bookFOS = new FileOutputStream(savebookFile);
            ObjectOutputStream bookOOS = new ObjectOutputStream(bookFOS);
            bookOOS.writeObject(books);
            bookOOS.flush();
            bookOOS.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void saveOrders() {
        try{
            File saveorderFile = new File ("Orders.txt");
            FileOutputStream orderFOS = new FileOutputStream(saveorderFile);
            ObjectOutputStream orderOOS = new ObjectOutputStream(orderFOS);
            orderOOS.writeObject(orders);
            orderOOS.flush();
            orderOOS.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void saveData() throws IOException {
        saveUsers();
        saveBooks();
        saveOrders();
    }
    public void close(Stage stage) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Close");
        alert.setHeaderText("You're about to Close Programme!");
        alert.setContentText("Do you want to save before exiting?");

        if (alert.showAndWait().get() == ButtonType.OK){
           // System.out.println("You successfully logged out");
           saveData();
            stage.close();
        }
    }
    public static void main(String[] args) throws IOException {


        launch();
    }
    // save orders needs to be checked
    // search engine has errors
    // save of borrowers and purchase
}