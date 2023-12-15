package AdminPackage;

import com.example.libirary_.Borrower;
import InterfacesPackage.CommonFunctions;
import com.example.libirary_.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import registrationsystem.DataConstraints;

import java.io.IOException;

import static com.example.libirary_.Borrower.BorrowerNum;
import static com.example.libirary_.Borrower.borrowers;
import static com.example.libirary_.User.users;


public class AdminFunctionalities implements CommonFunctions, DataConstraints
{
    @FXML
    Button updateBookInfoButton,RemoveBook;
    @FXML
    TextField BorrowerName,EmailBorrower,PasswordBorrower,NameOfBorrower,EmailOfBorrower,PasswordOfBorrower,CurrentEmail;
    public void addBorrower(ActionEvent e) throws IOException {
        // BorrowerNum+=1;
        try{
            String borrowusername,borrowemail,borrowpassword;
            try {
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
                for(int i=0;i<users.size();i++)
                {
                    if(borrowemail.compareTo(users.get(i).getEmail())==0)
                    {
                        signedInSuccessfully = false;
                        System.out.println("email");

                    }
                }
                if (!signedInSuccessfully) {
                    // switch to libraryScene
                    this.showAlert("email format must be correct and Password Must be Strong");
                    PasswordBorrower.clear();
                    BorrowerName.clear();
                    EmailBorrower.clear();
                }
                else
                {
                    //Mazen Mohammed
                    User u=new User(BorrowerName.getText(),EmailBorrower.getText(),PasswordBorrower.getText());
                    users.add(u); // user constructor already adds u to the array list
                    Borrower bro=new Borrower(BorrowerNum,BorrowerName.getText(),EmailBorrower.getText(),PasswordBorrower.getText());
                    borrowers.add(bro); // borrower extends user so we dont need to make an object of user
                    System.out.println(borrowers.size());
                }
            }catch (NullPointerException ex){
                System.out.println(ex.getMessage());
                this.showAlert("enter information then please press enter");
            }
        }
        catch(NullPointerException n) {
            System.out.println("ok");
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
                //System.out.println(users.size());
                //  System.out.println(ChangeSuccesfully);
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
