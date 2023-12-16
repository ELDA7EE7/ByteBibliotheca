package AdminPackage;

import com.example.libirary_.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RemoveBookFunctions {
    int index;

    @FXML
    private Label RemoveAuthor,RemovePrice,RemoveTitle,RemovePublishYear,RemoveGenre,RemoveAvailable,Success;
    @FXML
    private TextField RemoveBookname,RemoveNameAuthor;
    @FXML
    private ImageView RemoveImage;
    private Image image;
    String NameBook;
    String NameAuthor;

    public void ViewBookToRemove(ActionEvent event){
        try {
            index = Integer.MAX_VALUE;

            String NameBook =RemoveBookname.getText(),NameAuthor= RemoveNameAuthor.getText();
            for (int i = 0; i< Book.books.size(); i++){
                if (Book.books.get(i).getTitle().equalsIgnoreCase(NameBook)&&Book.books.get(i).getAuthor().equalsIgnoreCase(NameAuthor) ){
                    index= i;
                }
            }
            RemoveAuthor.setText(Book.books.get(index).getAuthor()); //show Book Author
            RemovePrice.setText(Float.toString(Book.books.get(index).getPrice()));//show Book Price
            RemoveTitle.setText(Book.books.get(index).getTitle());//show Book Title
            RemovePublishYear.setText(Integer.toString(Book.books.get(index).getPublishYear()));//show Book PublishYear
            RemoveGenre.setText(Book.books.get(index).getGenre());//show Book Genre

            String avilable=new String(Book.books.get(index).getStatus());
            //jada
            if (avilable.equalsIgnoreCase("in stock")){//show Book status
                RemoveAvailable.setText("in stock");
            }
            else{
                RemoveAvailable.setText("out stock");

            }
            //RemoveImage.setCache(false);
            //image=new Image(Book.books.get(index).getImagepath());
            //RemoveImage.setImage(image); //show book image

        }catch (Exception e){
            System.out.println(e.getMessage());
            Success.setText("Wrong BookName or Author");

        }
    }
    public void DeleteBook(ActionEvent e){
        try{
            Book.books.remove(index);


            RemoveBookname.setText("");
            RemoveNameAuthor.setText("");
            RemoveAuthor.setText("");
            RemovePrice.setText("");
            RemoveTitle.setText("");
            RemovePublishYear.setText("");
            RemoveGenre.setText("");
            RemoveAvailable.setText("");
            image=new Image("");
            RemoveImage.setCache(false);
            RemoveImage.setImage(null);
        }
        catch(Exception event)
        {
            System.out.println(event.getMessage());
        }
    }
}
