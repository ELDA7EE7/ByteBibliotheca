package shoppingcart.commands;

import com.example.libirary_.Book;
import shoppingcart.ShoppingCart;

public class QuantityUpdater implements ShoppingCartCommand {
    private final Book book;
    private final int updatedQuantity;
    private final int bookAmountAvailable;

    public QuantityUpdater(Book book, int updatedQuantity) {
        this.book = book;
        this.updatedQuantity = updatedQuantity;
        this.bookAmountAvailable = book.getBookAmountAvailable();
    }

    @Override
    public void execute(ShoppingCart shoppingCart) {
        for (Book currentBook : shoppingCart.getBooks()) {
            if (currentBook.getBookID() == this.book.getBookID()) {
                if(updatedQuantity<=bookAmountAvailable) {
                    currentBook.setBookCounterInShoppingCart(updatedQuantity);
                }
                else {
                    currentBook.setBookAmountAvailable(bookAmountAvailable);
                }
                break;
            }
        }
    }
}