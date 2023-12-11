package com.example.libirary_;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Purchase  extends UserInformation {


    private  String CustomerName;
    private final int  CustomerId;
    private boolean HasDiscount=true;
    public static int CustomerNum;
    private boolean Isbuying;
    private ArrayList<Integer> PurchaseBookID=new ArrayList<Integer>();
   //private ArrayList<LocalDateTime>ExpireDate=new ArrayList<LocalDateTime>();
    private ArrayList<LocalDateTime>DateofPurchase=new ArrayList<LocalDateTime>();
   // private ArrayList<Boolean>IsReturned=new ArrayList<Boolean>();


    LocalDate currentDate = LocalDate.now();

    public Purchase(int userID, String userName, String email, String password) {
        super(userID, userName, email, password);
        CustomerNum++;
        CustomerId= CustomerNum;
        CustomerName=userName;
    }

    public void PurchasedBook(Book book)
    {
        if(book.getInStock()>0)
        {
            System.out.println("This book is available ,If you want to Purchase it press Y");
            System.out.println(book.getPrice()+"has been deducted form your Account ");
            book.setInStock(book.getInStock()-1);
            DateofPurchase.add(java.time.LocalDateTime.now());
            PurchaseBookID.add(book.getBookID());
        }
        else
        {
            System.out.println("This book is not available at the moment");

            /// restock the current book

        }
    }

      public void ApplyDiscount(){

      }


}
