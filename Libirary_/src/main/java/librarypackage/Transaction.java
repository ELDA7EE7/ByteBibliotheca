package librarypackage;

import UsersOfLibrary.Borrower;

import java.util.Date;

public class Transaction {
    private Book borrowedBook;
    private Borrower currentBorrower;
    private Date borrowDate,
    returnDate;

    public Transaction(Book borrowedBook, Borrower currentBorrower, Date borrowDate, Date returnDate) {
        this.borrowedBook = borrowedBook;
        this.currentBorrower = currentBorrower;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }
    public Book getBorrowedBook() {
        return borrowedBook;
    }

    public void setBorrowedBook(Book borrowedBook) {
        this.borrowedBook = borrowedBook;
    }

    public Borrower getCurrentBorrower() {
        return currentBorrower;
    }

    public void setCurrentBorrower(Borrower currentBorrower) {
        this.currentBorrower = currentBorrower;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

}
