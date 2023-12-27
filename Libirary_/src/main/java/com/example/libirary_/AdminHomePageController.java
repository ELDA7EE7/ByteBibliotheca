package com.example.libirary_;
import AdminPackage.AdminFunctionalities;
import InterfacesPackage.CommonFunctions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminHomePageController extends AdminFunctionalities implements CommonFunctions {
  private   Stage stage;
  private Parent root;
   private Scene scene;


  /*  public void AddBorrower2(ActionEvent event){
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
    }*/

    @FXML
    public void switchToUpdateBookInfoPageScene(ActionEvent event) throws IOException { //Change Scene to Update Book Info Page
        root = FXMLLoader.load(getClass().getResource("UpdateBookInfo.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.getScene().setRoot(root);
        /*scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setFullScreen(true);*/
    }

    @FXML
    public void switchToRemoveBook(ActionEvent event) throws IOException { //Change Scene to Remove Book Page
        root = FXMLLoader.load(getClass().getResource("RemoveBook.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.getScene().setRoot(root);
        /*scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setFullScreen(true);*/
    }





    @FXML
    public void SwitchToAddBookScene(ActionEvent event) throws IOException { // Change Scene to Add Book Page
        root = FXMLLoader.load(getClass().getResource("AddBookScene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.getScene().setRoot(root);
        /*scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setFullScreen(true);*/
    }
}

