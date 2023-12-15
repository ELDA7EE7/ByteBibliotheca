package registrationsystem;

import InterfacesPackage.CommonFunctions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class RegistrationSystem implements CommonFunctions {

    @FXML
    protected TextField
            usernameTextField,
            emailTextField,
            enterPasswordField;

 /* void showAlert(String message){
        // Alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }*/
    @FXML
    public void switchToSignInAsUserScene(ActionEvent event) throws IOException {
        SwitchToNextScene(event,"LogInAsUserScene.fxml");
    }
    @FXML
    public void switchToAdminHomePageScene(ActionEvent event) throws  IOException{
        SwitchToNextScene(event,"AdminHomePage.fxml");
    }
    @FXML
    public void switchToHomePageScene(ActionEvent event) throws IOException {
        SwitchToNextScene(event,"HomePageScene.fxml");
    }

    @FXML
    public void switchToCreateNewUserAccountScene(ActionEvent event) throws IOException {
      SwitchToNextScene(event,"SignUp.fxml");
    }


}
