package InterfacesPackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Pattern;

import static librarypackage.Library.books;

public interface CommonFunctions {

    default void SwitchToNextScene(MouseEvent event, String nameOfNextScene) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource(nameOfNextScene));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }

    default void SwitchToNextScene(ActionEvent event,String nameOfNextScene) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource(nameOfNextScene));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }
    default void showAlert(String message){
        // Alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    default int SearchForBookByNameAndAuthor(String name,String author){
        int index=Integer.MAX_VALUE;
        for (int i = 0; i< books.size(); i++){
            if (books.get(i).getTitle().equalsIgnoreCase(name)&&books.get(i).getAuthor().equalsIgnoreCase(author) ){
                index= i;
            }
        }
        return index;
    }

}
