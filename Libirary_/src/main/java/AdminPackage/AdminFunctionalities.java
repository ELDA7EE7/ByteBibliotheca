package AdminPackage;

import UsersOfLibrary.Borrower;
import InterfacesPackage.CommonFunctions;
import UsersOfLibrary.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

import static librarypackage.Library.users;

import static UsersOfLibrary.Borrower.borrowers;


public class AdminFunctionalities implements CommonFunctions
{
    @FXML
    Button updateBookInfoButton,RemoveBook;
    @FXML
    TextField BorrowerName,EmailBorrower,PasswordBorrower,NameOfBorrower,EmailOfBorrower,PasswordOfBorrower,CurrentEmail,BorID;
    public void addBorrower(ActionEvent e) throws IOException {
            try {
                String borrowusername,borrowemail,borrowpassword;
                borrowusername =this.BorrowerName.getText();
                borrowemail = this.EmailBorrower.getText();
                borrowpassword = this.PasswordBorrower.getText();

                boolean signedInSuccessfully = true;
                if (this.checkName(borrowusername) == false) {
                    System.out.println("Please Enter only characters in user name field");
                    //  usernameLabel.setText("* Please Enter only characters in user name field");
                    BorrowerName.clear();
                    signedInSuccessfully = false;
                }
                if (this.checkPasswordIsStrong(borrowpassword) == false) {
                    System.out.println("Please Enter Strong Password with out space ");
                    // enterpasswordLabel.setText("* Please Enter Strong Password with out space");
                    PasswordBorrower.clear();
                    signedInSuccessfully = false;
                }
                if (!this.isValidEmail(borrowemail)) {
                    System.out.println("invalid email");
                    signedInSuccessfully = false;
                }
                for (User user : users) {
                    if (borrowemail.compareTo(user.getEmail()) == 0) {
                        signedInSuccessfully = false;
                        System.out.println("email");

                    }
                }
                if (!signedInSuccessfully){
                    showAlert("wrong input");
                    return;
                }


                    Borrower bro=new Borrower(BorrowerName.getText(),EmailBorrower.getText(),PasswordBorrower.getText());
            }catch (NullPointerException ex){
                System.out.println(ex.getMessage());
                this.showAlert("enter information then please press enter");
            }
    }
    int index;

    boolean ChangeSuccesfully=false;

    public void ViewBorrower(ActionEvent e) throws IOException {

        String C_Email = CurrentEmail.getText();
        for (int i = 0; i < users.size(); i++) {
            if (C_Email.compareTo(users.get(i).getEmail()) == 0) {
                ChangeSuccesfully = true;
                index = i;
                NameOfBorrower.setText(users.get(i).getName());
                EmailOfBorrower.setText(users.get(i).getEmail());
                PasswordOfBorrower.setText(users.get(i).getPassword());

            } else {

                PasswordOfBorrower.setText(null);
                NameOfBorrower.setText(null);
                EmailOfBorrower.setText(null);

            }
        }
    }

    public void UpdateBorrowers(ActionEvent e) throws IOException
    {    String Password=PasswordOfBorrower.getText(),Username=NameOfBorrower.getText(),Email=EmailOfBorrower.getText();

        try{

            if(ChangeSuccesfully) {
                users.get(index).setEmail(Email);
                users.get(index).setPassword(Password);
                users.get(index).setName(Username);
                ChangeSuccesfully = false;
            }
        }
        catch (NullPointerException n) {
        }
    }
    public void RemoveBorrowers(ActionEvent e) throws IOException
    {
        if(ChangeSuccesfully){
            users.remove(index);
            ChangeSuccesfully=false;
            PasswordOfBorrower.setText("");
            NameOfBorrower.setText("");
            EmailOfBorrower.setText("");
            CurrentEmail.setText("");

            // System.out.println(users.size());
            //  System.out.println(ChangeSuccesfully);

        }


    }
    public void Back(ActionEvent event) throws IOException {
        SwitchToNextScene(event,"AdminHomePage.fxml");
    }
}
