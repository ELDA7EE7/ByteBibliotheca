package FileHandlingPackage;

import UsersOfLibrary.Borrower;
import UsersOfLibrary.User;
import librarypackage.Book;
import librarypackage.Transaction;
import userprofile.Order;

import java.io.*;
import java.util.ArrayList;

import static librarypackage.Library.*;

public class FileHandling {
    public static void loadUsers(){
        try{
            File loaduserFile = new File("Users.txt");
            FileInputStream userFIS= new FileInputStream(loaduserFile);
            ObjectInputStream userOIS = new ObjectInputStream(userFIS);
            users =(ArrayList<User>) userOIS.readObject();
            System.out.println("size of users " + users.size());
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
            System.out.println("size of books " +books.size());
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
            System.out.println("size of orders " +orders.size());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void loadTransactions(){
        try{
            File loadTransactionFile = new File("Transactions.txt");
            FileInputStream transactionFIS= new FileInputStream(loadTransactionFile);
            ObjectInputStream transactionOIS = new ObjectInputStream(transactionFIS);
            transactions =(ArrayList<Transaction>) transactionOIS.readObject();
            System.out.println("size of transactions " +transactions.size());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void loadBorrowers(){
        try{
            File loadBorrowerFile = new File("Borrowers.txt");
            FileInputStream borrowerFIS= new FileInputStream(loadBorrowerFile);
            ObjectInputStream borrowerOIS = new ObjectInputStream(borrowerFIS);
            borrowers =(ArrayList<Borrower>) borrowerOIS.readObject();
            System.out.println("size of borrowers " +  borrowers.size());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void loadData(){
        loadUsers();
        loadBooks();
        loadOrders();
        loadTransactions();
        loadBorrowers();
    }
    public static void saveUsers() throws IOException {
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
    public static void saveBooks() {
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
    public static void saveOrders() {
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
    public static void saveTransactions() {
        try{
            File saveTransactionFile = new File ("Transactions.txt");
            FileOutputStream transactionFOS = new FileOutputStream(saveTransactionFile);
            ObjectOutputStream transactionOOS = new ObjectOutputStream(transactionFOS);
            transactionOOS.writeObject(transactions);
            transactionOOS.flush();
            transactionOOS.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public  static void saveBorrowers(){
        try{
            File saveBorrowerFile = new File ("Borrowers.txt");
            FileOutputStream borrowerFOS = new FileOutputStream(saveBorrowerFile);
            ObjectOutputStream borrowerOOS = new ObjectOutputStream(borrowerFOS);
            borrowerOOS.writeObject(borrowers);
            borrowerOOS.flush();
            borrowerOOS.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void saveData() throws IOException {
        saveUsers();
        saveBooks();
        saveOrders();
        saveTransactions();
        saveBorrowers();
    }
}
