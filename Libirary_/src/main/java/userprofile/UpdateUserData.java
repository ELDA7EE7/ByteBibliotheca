package userprofile;

import com.example.libirary_.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import registrationsystem.DataConstraints;

public abstract class UpdateUserData extends UserProfile implements UpdateUserDataInterface , DataConstraints {

    @FXML
    TextField nameTextField,emailTextField,passwordTextField;

    User user = User.getCurrentUser();
    @FXML
    public void update(ActionEvent event){
           try
           {
               updateName(nameTextField.getText());

           }catch (NullPointerException ex){
              System.out.println(ex.toString());
           }
         try
         {
            updateEmail(emailTextField.getText());
            fillEmailLabel();
         }catch (NullPointerException ex){
             System.out.println(ex.toString());
         }
         try
         {
             updatePassword(passwordTextField.getText());
             fillPasswordLabel();
         }catch (NullPointerException ex){
             System.out.println(ex.toString());
         }
    }
    @Override
    public void updateName(String newName){
            if(checkName(newName)) {
                user.setName(newName);
                fillNameLabel();
            }
    }
    @Override
    public  void updateEmail(String newEmail){
          if(isValidEmail(newEmail))
          {
            user.setEmail(newEmail);
            fillEmailLabel();
          }
    }
    @Override
    public void updatePassword(String newPassword){
        if(checkPasswordIsStrong(newPassword))
        {
            user.setPassword(newPassword);
             fillPasswordLabel();
        }
    }

}
