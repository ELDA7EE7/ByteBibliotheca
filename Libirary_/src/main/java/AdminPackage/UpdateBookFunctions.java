package AdminPackage;

import InterfacesPackage.CommonFunctions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static librarypackage.Library.books;

public class UpdateBookFunctions implements CommonFunctions {
    @FXML
    TextField priceTextField
            ,searchAuthorTextField
            ,titleTextField
            ,publishYearTextField
            ,indexsearchTextField
            ,genreTextField
            ,authorTextField
            ,daysTillReturnTextField
            ,ratingTextField
            ,amountAvailableTextField;
    @FXML
    private CheckBox statusCheckBox,availableCheckBox;
    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private Label successLabel;
    @FXML
    private ImageView coverImageView;
    private Image coverImage ;
    int index;
    public void ResetAll(){
        indexsearchTextField.clear();
        searchAuthorTextField.clear();
        amountAvailableTextField.clear();
        descriptionTextArea.clear();
        authorTextField.clear();
        genreTextField.clear();
        publishYearTextField.clear();
        titleTextField.clear();
        priceTextField.clear();
        daysTillReturnTextField.clear();
        ratingTextField.clear();
        availableCheckBox.setSelected(false);
        statusCheckBox.setSelected(false);

    }
    public void ShowDataInTextFeilds(){
        authorTextField.setText(books.get(index).getAuthor());
        priceTextField.setText(Float.toString(books.get(index).getPrice()));
        titleTextField.setText(books.get(index).getTitle());
        publishYearTextField.setText(Integer.toString(books.get(index).getPublishYear()));
        genreTextField.setText(books.get(index).getGenre());
        availableCheckBox.setSelected(books.get(index).isAvailable());
        daysTillReturnTextField.setText(Integer.toString(books.get(index).getDaysTillReturn()));
        ratingTextField.setText(Float.toString(books.get(index).getRating()));
        amountAvailableTextField.setText(Integer.toString(books.get(index).getBookAmountAvailable()));
        descriptionTextArea.setText(books.get(index).getDescription());
        String available=new String(books.get(index).getStatus());

        if (available.equalsIgnoreCase("in stock")){
            statusCheckBox.setSelected(true);
        }
        else{
            statusCheckBox.setSelected(false);

        }
        coverImage = new Image(books.get(index).getCoverPath());
        coverImageView.setImage(coverImage);
    }
    public void ViewBookToUpdate(ActionEvent event){
        try {
            index=Integer.MAX_VALUE;
            successLabel.setText("");
            String bookname = indexsearchTextField.getText(),bookauthor= searchAuthorTextField.getText();
            index= SearchForBookByNameAndAuthor(bookname,bookauthor);
            ShowDataInTextFeilds();
        }catch (Exception e){
            showAlert("Book not found");
            System.out.println(e.getMessage());
        }

    }
    public void SaveTheDataInTheBook(){
        //check if any text field is empty
        if(indexsearchTextField.getText().isEmpty()
                ||searchAuthorTextField.getText().isEmpty()
                ||authorTextField.getText().isEmpty()
                || titleTextField.getText().isEmpty()
                || genreTextField.getText().isEmpty()
                || priceTextField.getText().isEmpty()
                || publishYearTextField.getText().isEmpty()
                || daysTillReturnTextField.getText().isEmpty()
                || ratingTextField.getText().isEmpty()
                || descriptionTextArea.getText().isEmpty()
                || amountAvailableTextField.getText().isEmpty()){
            showAlert("Please Enter all the data");
            return;
        }

        books.get(index).setAuthor(authorTextField.getText());
        books.get(index).setTitle(titleTextField.getText());
        books.get(index).setGenre(genreTextField.getText());
        books.get(index).setPrice(Float.parseFloat(priceTextField.getText()));
        books.get(index).setPublishYear(Integer.parseInt(publishYearTextField.getText()));
        books.get(index).setDaysTillReturn(Integer.parseInt(daysTillReturnTextField.getText()));
        books.get(index).setAvailable(availableCheckBox.isSelected());
        books.get(index).setRating(Float.parseFloat(ratingTextField.getText()));
        books.get(index).setDescription(descriptionTextArea.getText());
        books.get(index).setBookAmountAvailable(Integer.parseInt(amountAvailableTextField.getText()));
        if(statusCheckBox.isSelected()){
            books.get(index).setStatus("In stock");
        }
        else{
            books.get(index).setStatus("Out of stock");
        }

        successLabel.setText("Book Updated Successfully");
    }
    public void PrintStuffForDebugging(){
        System.out.println(books.get(index).getBookID());
        System.out.println(books.get(index).getGenre());
        System.out.println(books.get(index).getAuthor());
        System.out.println(books.get(index).getPrice());
        System.out.println(books.get(index).getPublishYear());
        System.out.println(books.get(index).getTitle());
        System.out.println(books.get(index).getStatus());
        System.out.println(books.get(index).getDaysTillReturn());
        System.out.println(books.size());
    }
    public void UpdateBookInfo(ActionEvent event) {
        try{

            SaveTheDataInTheBook();
            ResetAll();
            PrintStuffForDebugging();
        }catch(Exception e){
            showAlert("Please Enter all the data");
            System.out.println(e.getMessage());
        }
    }
}
