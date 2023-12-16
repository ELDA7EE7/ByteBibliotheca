package shoppingcart.commands;

import com.example.libirary_.Book;
import shoppingcart.Discount;
import shoppingcart.ShoppingCart;

import java.util.List;

public class BookPriceCalculator implements ShoppingCartCommand {
    public BookPriceCalculator(){};
    @Override
    public void execute(ShoppingCart shoppingCart) {
        for (Book currentBook : shoppingCart.getBooks()) {
            currentBook.setTotalPriceInShoppingCart(currentBook.getPrice() * currentBook.getBookCounterInShoppingCart());
        }
    }
}
