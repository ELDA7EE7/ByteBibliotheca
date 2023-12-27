package registrationsystem;

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

public abstract class RegistrationSystem {

    @FXML
    protected TextField
            usernameTextField,
            emailTextField,
            enterPasswordField;
    private Scene scene;
    private Stage stage;

 protected void showAlert(String message){
        // Alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    @FXML
    public void switchToSignInAsUserScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LogInAsUserScene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.getScene().setRoot(root);
        /*scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setFullScreen(true);*/
    }
    @FXML
    public void switchToAdminHomePageScene(ActionEvent event) throws  IOException{
        Parent root = FXMLLoader.load(getClass().getResource("AdminHomePage.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.getScene().setRoot(root);
        /*scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setFullScreen(true);*/
    }
    @FXML
    public void switchToHomePageScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.getScene().setRoot(root);
        /*scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setFullScreen(true);*/
    }

    @FXML
    public void switchToCreateNewUserAccountScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.getScene().setRoot(root);
        /*scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setFullScreen(true);*/
    }


}
