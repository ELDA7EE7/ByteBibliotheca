package com.example.libirary_;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Borrower extends UserInformation
{
    private  String BorrowerName;
    private final int  BorrowerId;
    public static int BorrowerNum;
    private boolean IsBorrowing;
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
        BorrowerName=userName;

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
            ExpireDate.add(java.time.LocalDateTime.now().plusDays(book.getExpiryDate()));
            IsBorrowing=true;
            BorrowedBookID.add(book.getBookID());
            book.setAvailable(false);
            IsReturned.add(true);
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


}
