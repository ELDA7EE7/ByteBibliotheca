package userprofile;

import UsersOfLibrary.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import librarypackage.Transaction;

import java.util.ArrayList;

import static UsersOfLibrary.User.getCurrentUser;
import static librarypackage.Library.orders;
import static librarypackage.Library.transactions;

public class UserProfile implements UploadUserInformation {
    @FXML
    protected Label emailLabel, nameLabel, passwordLabel, idLabel;
    @FXML
    protected ListView<String> listViewOrders, listViewTransactions;
    private final ArrayList<String> ordersList = new ArrayList<>();

    private final ArrayList<String> transactionList = new ArrayList<>();
    User user = getCurrentUser();


    @Override
    public void fillListviewWithUserOrders() {
        for (Order order : orders) {
            if (user.findOrderID(order.getOrderId())) {
                ordersList.add(order.toString());
            }
        }
        try {
            listViewOrders.getItems().addAll(ordersList);
        } catch (NullPointerException e) {
            System.out.println("Empty Order List");
        }
    }

    @Override
    public void fillListviewWithUserTransaction() {
        for (Transaction t : transactions) {
            if(t.getBorrower().getId()==getCurrentUser().getId()){
                  transactionList.add(t.toString2());
            }
        }
        try {
            listViewTransactions.getItems().addAll(transactionList);
        } catch (NullPointerException e) {
            System.out.println("Empty Transaction List");
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

