package UsersOfLibrary;
import com.example.libirary_.Book;
import com.example.libirary_.UserProfileController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import static librarypackage.Library.books;
import static librarypackage.Library.users;

public class Borrower extends User
{
    private final int  BorrowerId;
    public static int BorrowerNum;
    public static int CurrentBorrowerId=getCurrentUser().getId();
    private boolean IsBorrowing;
    private String PhoneNumber ;
    private Borrower current_borrower;
    public static ArrayList<Borrower> borrowers = new ArrayList<Borrower>();

    private ArrayList<Integer>BorrowedBookID=new ArrayList<Integer>();
    private ArrayList<LocalDateTime>DaysTillReturn=new ArrayList<LocalDateTime>();
    private ArrayList<LocalDateTime>DateofBorrow=new ArrayList<LocalDateTime>();
    private ArrayList<Boolean>IsReturned=new ArrayList<Boolean>();


    LocalDate currentDate = LocalDate.now();

    public Borrower(int userID, String userName, String email, String password)
    {
        super(userID, userName, email, password);
        BorrowerId=userID;
        BorrowerNum= BorrowerId;
        borrowers.add(this);
        for (User u:users) {
            if (u.getId()==CurrentBorrowerId ) current_borrower =getCurrent_borrower(CurrentBorrowerId);
        }
    }


    public void BorrowBook(Book book)
    {
        if(!book.isAvailable())
        {
            System.out.println("This book is not available at the moment");
        }
        else
        {
            System.out.println("This book is available ,If you want to borrow it press Y");
            book.setAvailable(false);

            DateofBorrow.add(java.time.LocalDateTime.now());
            DaysTillReturn.add(java.time.LocalDateTime.now().plusDays(book.getDaysTillReturn()));

            IsBorrowing=true;
            current_borrower.BorrowedBookID.add(book.getBookID());
            book.setAvailable(false);
            current_borrower.IsReturned.add(true);
        }
    }
    public Borrower getCurrent_borrower(int userId){
        for (Borrower borro:borrowers){
            if (borro.getId()==userId)return borro;
        }
        return null;
    }

    public void BorrowedBookIsExpired(Borrower borrower)
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

    public Borrower getCurrent_borrower() {
        return current_borrower;
    }

    public void setCurrent_borrower(Borrower current_borrower) {
        this.current_borrower = current_borrower;
    }
}
