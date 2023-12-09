package com.example.libirary_;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.libirary_.Borrower.BorrowerNum;
import static com.example.libirary_.Borrower.borrowers;
import static com.example.libirary_.User.users;
import static com.example.libirary_.UserInformation.*;

public class AdminHomePageController implements CommonFunctions {
  private   Stage stage;
  private Parent root;
   private Scene scene;
    @FXML
    Button updateBookInfoButton,RemoveBook;
    @FXML
    TextField BorrowerName,EmailBorrower,PasswordBorrower,NameOfBorrower,EmailOfBorrower,PasswordOfBorrower,CurrentEmail;

    @FXML
    public void switchToUpdateBookInfoPageScene(ActionEvent event) throws IOException { //Change Scene to Update Book Info Page
        root = FXMLLoader.load(getClass().getResource("UpdateBookInfo.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }

    @FXML
    public void switchToRemoveBook(ActionEvent event) throws IOException { //Change Scene to Remove Book Page
        root = FXMLLoader.load(getClass().getResource("RemoveBook.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }

    public void addBorrower(ActionEvent e) throws IOException{
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
                    if(borrowemail.compareTo(users.get(i).getEmailInfo())==0)
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
                    users.add(u);
                    Borrower bro=new Borrower(BorrowerNum,BorrowerName.getText(),EmailBorrower.getText(),PasswordBorrower.getText());
                    borrowers.add(bro);
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
                if (C_Email.compareTo(users.get(i).getEmailInfo()) == 0) {
                    ChangeSuccesfully = true;
                    index = i;
                    NameOfBorrower.setText(users.get(i).getUsernameInfo());
                    EmailOfBorrower.setText(users.get(i).getEmailInfo());
                    PasswordOfBorrower.setText(users.get(i).getPasswordInfo());

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
              User.users.get(index).setEmailInfo(Email);
              User.users.get(index).setPasswordInfo(Password);
              User.users.get(index).setUserNameInfo(Username);
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
              User.users.remove(index);
              ChangeSuccesfully=false;
              PasswordOfBorrower.setText("");
              NameOfBorrower.setText("");
              EmailOfBorrower.setText("");
              CurrentEmail.setText("");

             // System.out.println(users.size());
              //  System.out.println(ChangeSuccesfully);

          }


      }


    }


