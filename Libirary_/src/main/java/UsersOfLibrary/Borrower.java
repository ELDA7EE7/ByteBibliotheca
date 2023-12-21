package UsersOfLibrary;
import FileHandlingPackage.FileHandling;
import InterfacesPackage.CommonFunctions;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import librarypackage.Book;
import librarypackage.Transaction;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import static librarypackage.Library.*;

public class Borrower extends User implements CommonFunctions
{
    private final int  BorrowerId;
    public static int BorrowerNum;
    //public static int CurrentBorrowerId = getCurrentUser().getId();
    private boolean IsBorrowing;
   // private static int BorrowerCount=1;
    private String PhoneNumber ;
    public static Borrower current_borrower;
    public static ArrayList<Borrower> borrowers = new ArrayList<Borrower>();
    public ArrayList<Book> notifyWhenAvailableBook = new ArrayList<Book>();

    public ArrayList<Integer>BorrowedBookID=new ArrayList<Integer>();
    private ArrayList<LocalDateTime>DaysTillReturn=new ArrayList<LocalDateTime>();
    private ArrayList<LocalDateTime>DateofBorrow=new ArrayList<LocalDateTime>();
    private ArrayList<Boolean>IsReturned=new ArrayList<Boolean>();


    LocalDate currentDate = LocalDate.now();


   public Borrower(int userId,String userName, String email, String password)
    {
        super(userId,userName, email, password);
        BorrowerId=userId;
        BorrowerNum=BorrowerId;
        borrowers.add(this);
        for (User u:users) {
            if (u.getId()==getCurrentUser().getId() )
                current_borrower =getCurrent_borrower(getCurrentUser().getId());
        }
    }


    public void BorrowBook(Book book)
    {
        if(!book.isAvailable())
        {
            showAlert("This book is not available at the moment");
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Borrow Book");
            alert.setHeaderText("You're about to borrow book");
            alert.setContentText("if you need it Press OK");
            if (alert.showAndWait().get() == ButtonType.OK){
            book.setAvailable(false);
            DaysTillReturn.add(java.time.LocalDateTime.now().plusDays(book.getDaysTillReturn()));
            IsBorrowing=true;
            current_borrower.BorrowedBookID.add(book.getBookID());
            book.setAvailable(false);
            current_borrower.IsReturned.add(true);
            /*
             Book borrowedBook;
             Borrower currentBorrower;
             Date borrowDate,

             returnDate;
             */
                transactions.add(new Transaction(book,this,LocalDateTime.now(), DaysTillReturn.get(DaysTillReturn.size()-1)));
            }
        }
    }
    public Borrower getCurrent_borrower(int userId){
        for (Borrower borro:borrowers){
            if (borro.getId()==userId)return borro;
        }
        return null;
    }

    public void  BorrowedBookIsExpired(Borrower borrower)
    {
        for (int i=0;i<borrower.BorrowedBookID.size();i++)
        {
            if(IsReturned.get(i))
            {
                if (borrower.DaysTillReturn.get(i).isBefore(LocalDateTime.now()))
                {
                    System.out.println("Duration of the borrowed book has expired :" +" "+books.get(borrower.BorrowedBookID.get(i)).getTitle());
                    System.out.println("You will be fined 50$ ");
                    IsReturned.set(i,false);
                    books.get(borrower.BorrowedBookID.get(i)).setAvailable(true);
                }
                else if (borrower.DaysTillReturn.get(i).isAfter(LocalDateTime.now()))
                {
                    System.out.println("Due Time for the borrowed book :" +" "+books.get(borrower.BorrowedBookID.get(i)).getTitle()
                            +" "+ ChronoUnit.DAYS.between(LocalDate.now(), borrower.DaysTillReturn.get(borrower.BorrowedBookID.get(i))));
                }
            }

        }
    }
    public static Borrower getCurrent_borrower() {
        return current_borrower;
    }
    public static void setCurrent_borrower(Borrower currentborrower) {
        current_borrower = currentborrower;
    }
}
