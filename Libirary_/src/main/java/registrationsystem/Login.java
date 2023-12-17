package registrationsystem;

import com.example.libirary_.Book;
import com.example.libirary_.User;
import userprofile.Order;

public interface Login {
    default User findUser(String emailOrUsername,String password) {

        for (User user : User.users) {
            System.out.println(user.getEmail());
            System.out.println(user.getName());
            System.out.println(user.getPassword());

            System.out.println(emailOrUsername);
            System.out.println(password);

            if (((user.getEmail().equals(emailOrUsername)) || (user.getName().equals(emailOrUsername))) && user.getPassword().equals(password)) {
                User.setCurrentUser(user);
              
              //add order to Mazen to check if code run correctly
                //Order order = new Order(100.0f, Book.books.get(1), 3);
               // Order order = new Order(100.0f, Book.books.get(0), 3);
                //user.orders.add(order);
                return user;
            }
        }
        return null;
    }
}
