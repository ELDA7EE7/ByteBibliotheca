package librarypackage;

import UsersOfLibrary.Borrower;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Transaction implements Serializable {
    Book borrowedBook;
    Borrower borrower;
    LocalDateTime borrowDate,
    returnDate;

    public Transaction(Book borrowedBook, Borrower currentBorrower, LocalDateTime borrowDate, LocalDateTime returnDate) {
        this.borrowedBook = borrowedBook;
        this.borrower = currentBorrower;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }
    public Book getBorrowedBook() {
        return borrowedBook;
    }

    public void setBorrowedBook(Book borrowedBook) {
        this.borrowedBook = borrowedBook;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDateTime borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "borrowedBook=" + borrowedBook +
                ", borrower=" + borrower +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                '}';
    }

    public String toString2() {
        return "Transaction{" +
                "borrowedBook=" + borrowedBook.getTitle() +
                ", borrowDate=" + borrowDate.toString() +
                ", returnDate=" + returnDate.toString() +
                '}';
    }
}
