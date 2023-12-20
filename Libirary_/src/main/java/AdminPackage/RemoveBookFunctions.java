package AdminPackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static librarypackage.Library.books;

public class RemoveBookFunctions {
    int index;

    @FXML
    private Label RemoveAuthor,RemovePrice,RemoveTitle,RemovePublishYear,RemoveGenre,RemoveAvailable,RemoveCoverPath,RemoveRating,RemoveDes,RemoveExpire,Success;
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
            for (int i = 0; i< books.size(); i++){
                if (books.get(i).getTitle().equalsIgnoreCase(NameBook)&&books.get(i).getAuthor().equalsIgnoreCase(NameAuthor) ){
                    index= i;
                }
            }
            RemoveAuthor.setText(books.get(index).getAuthor()); //show Book Author
            RemovePrice.setText(Float.toString(books.get(index).getPrice()));//show Book Price
            RemoveTitle.setText(books.get(index).getTitle());//show Book Title
            RemovePublishYear.setText(Integer.toString(books.get(index).getPublishYear()));//show Book PublishYear
            RemoveGenre.setText(books.get(index).getGenre());//show Book Genre

            String avilable=new String(books.get(index).getStatus());
            //jada
            if (avilable.equalsIgnoreCase("in stock")){//show Book status
                RemoveAvailable.setText("in stock");
            }
            else{
                RemoveAvailable.setText("out stock");

            }
            RemoveImage.setCache(false);
            image=new Image(books.get(index).getCoverPath());
            RemoveImage.setImage(image); //show book image

        }catch (Exception e){
            System.out.println(e.getMessage());
            Success.setText("Wrong BookName or Author");

        }
    }
    public void DeleteBook(ActionEvent e){
        try{
            books.remove(index);


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
            RemoveExpire.setText("");
            RemoveDes.setText("");
            RemoveRating.setText("");
            RemoveCoverPath.setText("");
        }
        catch(Exception event)
        {
            System.out.println(event.getMessage());
        }
    }
}
