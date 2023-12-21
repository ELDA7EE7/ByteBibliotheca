package shoppingcart.commands;

import librarypackage.Book;
import shoppingcart.ShoppingCart;

public class BookCounter implements ShoppingCartCommand{
    @Override
    public void execute(ShoppingCart shoppingCart) {
        if (!shoppingCart.getBooks().isEmpty()) {
            Book firstBook = shoppingCart.getBooks().get(0);
            shoppingCart.setBookCount(firstBook.getBookCounterInShoppingCart());
            for (int i = 1; i < shoppingCart.getBooks().size(); i++) {
                Book currentBook = shoppingCart.getBooks().get(i);
                shoppingCart.setBookCount(shoppingCart.getBookCount() + currentBook.getBookCounterInShoppingCart());
            }
        }
        else{
            shoppingCart.setBookCount(0);
        }
    }
}
