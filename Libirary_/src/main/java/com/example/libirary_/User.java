package com.example.libirary_;

import userprofile.Order;

import java.util.ArrayList;

import static librarypackage.Library.users;

public class User extends Person{
    private static int userCounter =0;
    private static User currentUser;

  private ArrayList<Integer>userOrders = new ArrayList<>();//order id


   public User(int id,String userName, String email, String password){

       super(id,userName,email,password);
   }
    public User(String userName, String email, String password) {
        super(userCounter+1,userName,email,password);
        userCounter++;
        users.add(this);
    }
    public static int getUserCounter() {
        return userCounter;
    }

    public static User getCurrentUser() {
        return currentUser;
    }
    public static void setCurrentUser(User user){
        currentUser = user;
    }
    public void addOrder(int orderID){
       this.userOrders.add(orderID);
    }
    public boolean findOrderID(int orderId){

       for(Integer id : this.userOrders){
               if(orderId==id)
                   return true;
       }

       return false;
    }

}
