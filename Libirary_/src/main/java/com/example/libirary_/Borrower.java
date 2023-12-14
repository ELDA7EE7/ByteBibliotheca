package com.example.libirary_;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Borrower extends User
{
    private final int  BorrowerId;
    public static int BorrowerNum;
    private static Borrower current_borrower;
    private boolean IsBorrowing;
    private String PhoneNumber ;
    public static ArrayList<Borrower> borrowers = new ArrayList<Borrower>();



    private ArrayList<Integer>BorrowedBookID=new ArrayList<Integer>();
    private ArrayList<LocalDateTime>ExpireDate=new ArrayList<LocalDateTime>();
    private ArrayList<LocalDateTime>DateofBorrow=new ArrayList<LocalDateTime>();
    private ArrayList<Boolean>IsReturned=new ArrayList<Boolean>();


    LocalDate currentDate = LocalDate.now();

    public Borrower(int userID, String userName, String email, String password)
    {
        super(userID, userName, email, password);
        BorrowerNum++;
        BorrowerId=BorrowerNum;
        borrowers.add(this);
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
            current_borrower.DateofBorrow.add(java.time.LocalDateTime.now());
            current_borrower.ExpireDate.add(java.time.LocalDateTime.now().plusDays(book.getExpiryDate()));
            IsBorrowing=true;
            current_borrower.BorrowedBookID.add(book.getBookID());
            book.setAvailable(false);
            current_borrower.IsReturned.add(true);
        }
    }
    public void BorrowedBookIsExpired(Borrower borrower)
    {
        for (int i=0;i<borrower.BorrowedBookID.size();i++)
        {
            if(IsReturned.get(i))
            {
                if (borrower.ExpireDate.get(i).isBefore(java.time.LocalDateTime.now()))
                {
                    System.out.println("Duration of the borrowed book has expired :" +" "+Book.books.get(borrower.BorrowedBookID.get(i)).getTitle());
                    System.out.println("You will be fined 50$ ");
                    IsReturned.set(i,false);
                    Book.books.get(borrower.BorrowedBookID.get(i)).setAvailable(true);
                }
                else if (borrower.ExpireDate.get(i).isAfter(java.time.LocalDateTime.now()))
                {
                    System.out.println("Due Time for the borrowed book :" +" "+Book.books.get(borrower.BorrowedBookID.get(i)).getTitle()
                            +" "+ ChronoUnit.DAYS.between(LocalDate.now(), borrower.ExpireDate.get(borrower.BorrowedBookID.get(i))));
                }
            }

        }
    }

    public static void setCurrent_borrower(Borrower current_borrower) {
        Borrower.current_borrower = current_borrower;
    }

    public int getBorrowerId() {
        return BorrowerId;
    }
}
