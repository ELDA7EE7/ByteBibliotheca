package librarypackage;

import UsersOfLibrary.Borrower;

import java.io.Serializable;
import java.util.Date;

public class Transaction implements Serializable {
    Book borrowedBook;
    Borrower currentBorrower;
    Date borrowDate,
    returnDate;

}
