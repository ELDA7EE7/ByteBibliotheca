package com.example.libirary_;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Purchase  extends User {

    private final int  CustomerId;
    private boolean HasDiscount=true;
    public static int CustomerNum;
    private boolean Isbuying;
    private static Purchase current_Purchase;
    private ArrayList<Purchase>Purchase=new ArrayList<Purchase>();
    private ArrayList<Integer> PurchaseBookID=new ArrayList<Integer>();
   //private ArrayList<LocalDateTime>ExpireDate=new ArrayList<LocalDateTime>();
    private ArrayList<LocalDateTime>DateofPurchase=new ArrayList<LocalDateTime>();
   // private ArrayList<Boolean>IsReturned=new ArrayList<Boolean>();


    LocalDate currentDate = LocalDate.now();

    public Purchase(int userID, String userName, String email, String password) {
        super(userID, userName, email, password);
        CustomerNum++;
        CustomerId= CustomerNum;
        Purchase.add(this);
    }

    public void PurchasedBook(Book book)
    {
        if(book.getInStock()>0)
        {
            System.out.println("This book is available ,If you want to Purchase it press Y");
            System.out.println(book.getPrice()+"has been deducted form your Account ");
            book.setInStock(book.getInStock()-1);
            current_Purchase.DateofPurchase.add(java.time.LocalDateTime.now());
            current_Purchase.PurchaseBookID.add(book.getBookID());
        }
        else
        {
            System.out.println("This book is not available at the moment");

            /// restock the current book

        }
    }

      public void ApplyDiscount(){

      }

    public static Purchase getCurrent_Purchase() {
        return current_Purchase;
    }

    public static void setCurrent_Purchase(Purchase current_Purchase) {
       current_Purchase = current_Purchase;
    }
}
