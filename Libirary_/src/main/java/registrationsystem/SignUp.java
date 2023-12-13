package registrationsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public interface SignUp extends DataConstraints {

    @FXML
    void clickSignUp(ActionEvent event) throws IOException;
    void clearFields();
}
