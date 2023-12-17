package AdminPackage;

import InterfacesPackage.CommonFunctions;
import com.example.libirary_.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import resourcesimports.BooksImages;

public abstract class AddBookFunctions implements CommonFunctions {
    @FXML
    private TextField nameTextField,authorTextField,genreTextField,publishyearTextField,coverPathTextField,bookAmountAvailableTextField,priceTextField,daysTillReturnTextField;
    @FXML
    private CheckBox statusCheckBox,availableCheckBox;
    @FXML
    private Label successLabel;
    public void  CheckIfInputIsValid(){
        try {
            if(nameTextField.getText().isEmpty()
                    ||authorTextField.getText().isEmpty()
                    ||genreTextField.getText().isEmpty()
                    ||publishyearTextField.getText().isEmpty()
                    ||priceTextField.getText().isEmpty()
                    ||coverPathTextField.getText().isEmpty()
                    ||daysTillReturnTextField.getText().isEmpty()
                    ||bookAmountAvailableTextField.getText().isEmpty()){
                showAlert("Please Enter all the data");
                successLabel.setText("");

            }
        }catch (Exception e){
            showAlert("An error happened");
            System.out.println(e.getMessage());
        }


    }
    public void GetData(){
        String name = nameTextField.getText()
                ,author =authorTextField.getText()
                ,genre= genreTextField.getText()
                ,coverPath=coverPathTextField.getText()
                ,status;
        int publishyear=Integer.parseInt(publishyearTextField.getText()),daysTillReturn=Integer.parseInt(daysTillReturnTextField.getText()),bookAmountAvailable=Integer.parseInt(bookAmountAvailableTextField.getText());
        float price=Float.parseFloat(priceTextField.getText());
        boolean isAvailable=availableCheckBox.isSelected();
        if(statusCheckBox.isSelected()){
            status="In Stock";
        }
        else {
            status = "Out of Stock";
        }
        successLabel.setText("Book added successfully");

        Book newBook = new Book(name,author,status,publishyear,price,genre,coverPath,isAvailable,bookAmountAvailable,daysTillReturn);

        System.out.println(Book.books.size());
    }
    public void AddBook(ActionEvent event){
        CheckIfInputIsValid();
        GetData();
    }
}
