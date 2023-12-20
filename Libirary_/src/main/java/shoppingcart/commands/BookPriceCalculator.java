package shoppingcart.commands;

import librarypackage.Book;
import shoppingcart.ShoppingCart;

public class BookPriceCalculator implements ShoppingCartCommand {
    public BookPriceCalculator(){};
    @Override
    public void execute(ShoppingCart shoppingCart) {
        for (Book currentBook : shoppingCart.getBooks()) {
            currentBook.setTotalPriceInShoppingCart(currentBook.getPrice() * currentBook.getBookCounterInShoppingCart());
        }
    }
}
