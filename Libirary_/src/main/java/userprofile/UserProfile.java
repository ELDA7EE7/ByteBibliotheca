package userprofile;

import UsersOfLibrary.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.ArrayList;

import static librarypackage.Library.orders;

public class UserProfile implements UploadUserInformation {
    @FXML
    protected Label emailLabel, nameLabel, passwordLabel, idLabel;
    @FXML
    protected ListView<String> listView;
    private final ArrayList<String> ordersList = new ArrayList<>();
    User user = User.getCurrentUser();


    @Override
    public void fillListviewWithUserOrders() {
        for (Order order : orders) {
            if(user.findOrderID(order.getOrderId())) {
                ordersList.add(order.toString());
            }
        }
        try {
            listView.getItems().addAll(ordersList);
        } catch (NullPointerException e) {
            System.out.println("Empty Order List");
        }
    }

    @Override
    public void fillNameLabel() {
        try {
            nameLabel.setText(user.getName());
        } catch (NullPointerException e) {
        }
    }

    @Override
    public void fillEmailLabel() {
        try {
            emailLabel.setText(user.getEmail());
        } catch (NullPointerException e) {
        }
    }

    @Override
    public void fillPasswordLabel() {
        try {
            passwordLabel.setText(user.getPassword());
        } catch (NullPointerException e) {
        }
    }

    @Override
    public void fillIdLabel() {
        try {
            idLabel.setText(Integer.toString(user.getId()));
        } catch (NullPointerException e) {
        }
    }
}

