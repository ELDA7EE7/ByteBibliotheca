package UsersOfLibrary;

import userprofile.Order;

import java.util.ArrayList;

public class User extends Person {
    private static int userCounter =0;
    private static User currentUser;
   public static ArrayList<User> users = new ArrayList<User>();

   public ArrayList<Order> orders = new ArrayList<Order>();

   public User(int id,String userName, String email, String password){
       super(userCounter,userName,email,password);
   }
    public User(String userName, String email, String password) {
        super(userCounter,userName,email,password);
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


}
