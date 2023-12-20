package AdminPackage;

import InterfacesPackage.CommonFunctions;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import librarypackage.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static librarypackage.Library.books;

public abstract class AddBookFunctions implements CommonFunctions {
    @FXML
    private TextField nameTextField
            ,authorTextField
            ,genreTextField
            ,publishyearTextField
            ,coverPathTextField
            ,bookAmountTextField
            ,priceTextField
            ,daysTillReturnTextField
            ,descriptionTextField
            ,ratingTextField;
    @FXML
    private TextArea descriptionTextArea;
    @FXML
    private CheckBox statusCheckBox,availableCheckBox;
    @FXML
    private Label successLabel;
    public boolean  CheckIfInputIsValid(){
        try {
            if(nameTextField.getText().isEmpty()
                    ||authorTextField.getText().isEmpty()
                    ||genreTextField.getText().isEmpty()
                    ||publishyearTextField.getText().isEmpty()
                    ||priceTextField.getText().isEmpty()
                    ||coverPathTextField.getText().isEmpty()
                    ||daysTillReturnTextField.getText().isEmpty()
                    ||bookAmountTextField.getText().isEmpty()
                    ||ratingTextField.getText().isEmpty()
                    ||descriptionTextArea.getText().isEmpty()){
                showAlert("Please Enter all the data");
                return false;
            }
            Image testpath = new Image(coverPathTextField.getText());
            successLabel.setText("");
            return true;
        }
        catch (Exception e){
            showAlert("Image path is not valid");
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }


    }
    public void GetData(){
        try {
            String name = nameTextField.getText()
                    , author = authorTextField.getText()
                    , genre = genreTextField.getText()
                    , coverPath = coverPathTextField.getText()
                    , status
                    , description = descriptionTextArea.getText();

            int publishyear = Integer.parseInt(publishyearTextField.getText())
                    , daysTillReturn = Integer.parseInt(daysTillReturnTextField.getText())
                    , bookAmountAvailable = Integer.parseInt(bookAmountTextField.getText());

            float price = Float.parseFloat(priceTextField.getText()),
                    rating = Float.parseFloat(ratingTextField.getText());

            boolean isAvailable = availableCheckBox.isSelected();

            if (statusCheckBox.isSelected()) {
                status = "In Stock";
            } else {
                status = "Out of Stock";
            }
            if(rating>5.0F|| rating<0.0F){
                showAlert("Rating must be between 0 and 5");
                return;
            }
            successLabel.setText("Book added successfully");

            Book newBook = new Book(name, author, description, status, publishyear, rating, price, genre, coverPath, isAvailable, bookAmountAvailable, daysTillReturn);

        }
        catch (NumberFormatException e){
            showAlert("please enter a number");
            System.out.println(e.getMessage());
        }
    }
    public void AddBook(ActionEvent event){
        if(CheckIfInputIsValid())
         GetData();
    }
}
