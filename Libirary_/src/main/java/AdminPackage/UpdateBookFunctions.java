package AdminPackage;

import InterfacesPackage.CommonFunctions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static librarypackage.Library.books;

public class UpdateBookFunctions implements CommonFunctions {
    @FXML
    TextField updateAuthor,updatePrice,UpdateTitle,UpdatePublishYear,indexsearchTextField,genreTextField,authorTextField,daysTillReturnTextField;
    @FXML
    private CheckBox statusCheckBox,availableCheckBox;

    @FXML
    private Label successLabel;
    @FXML
    private ImageView coverImageView;
    private Image coverImage ;
    int index;
    public void ResetAll(){
        indexsearchTextField.clear();
        authorTextField.clear();
        genreTextField.clear();
        UpdatePublishYear.clear();
        UpdateTitle.clear();
        updatePrice.clear();
        updateAuthor.clear();
        daysTillReturnTextField.clear();
        availableCheckBox.setSelected(false);
        statusCheckBox.setSelected(false);

    }
    public void ShowDataInTextFeilds(){
        updateAuthor.setText(books.get(index).getAuthor());
        updatePrice.setText(Float.toString(books.get(index).getPrice()));
        UpdateTitle.setText(books.get(index).getTitle());
        UpdatePublishYear.setText(Integer.toString(books.get(index).getPublishYear()));
        genreTextField.setText(books.get(index).getGenre());
        availableCheckBox.setSelected(books.get(index).isAvailable());
        daysTillReturnTextField.setText(Integer.toString(books.get(index).getDaysTillReturn()));
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
            String bookname = indexsearchTextField.getText(),bookauthor= authorTextField.getText();
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
                ||updateAuthor.getText().isEmpty()
                || UpdateTitle.getText().isEmpty()
                || genreTextField.getText().isEmpty()
                ||updatePrice.getText().isEmpty()
                || UpdatePublishYear.getText().isEmpty()
                || daysTillReturnTextField.getText().isEmpty()){
            showAlert("Please Enter all the data");
            return;
        }

        books.get(index).setAuthor(updateAuthor.getText());
        books.get(index).setTitle(UpdateTitle.getText());
        books.get(index).setGenre(genreTextField.getText());
        books.get(index).setPrice(Float.parseFloat(updatePrice.getText()));
        books.get(index).setPublishYear(Integer.parseInt(UpdatePublishYear.getText()));
        books.get(index).setDaysTillReturn(Integer.parseInt(daysTillReturnTextField.getText()));
        books.get(index).setAvailable(availableCheckBox.isSelected());
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
