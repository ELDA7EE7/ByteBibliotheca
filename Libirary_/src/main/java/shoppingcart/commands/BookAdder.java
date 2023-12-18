package shoppingcart.commands;

import librarypackage.Book;
import shoppingcart.ShoppingCart;

public class BookAdder implements ShoppingCartCommand {
    private final Book book;
    public BookAdder(Book book) {
        this.book = book;
    }
    @Override
    public void execute(ShoppingCart shoppingCart) {
        book.setBookCounterInShoppingCart(book.getBookCounterInShoppingCart()+1);
        shoppingCart.getBooks().add(book);
    }
}