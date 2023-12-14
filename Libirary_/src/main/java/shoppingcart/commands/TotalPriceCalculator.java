package shoppingcart.commands;

import com.example.libirary_.Book;
import shoppingcart.ShoppingCart;

public class TotalPriceCalculator implements ShoppingCartCommand {
    public TotalPriceCalculator(){};
    @Override
    public void execute(ShoppingCart shoppingCart) {
        for (Book currentBook : shoppingCart.getBooks()) {
            shoppingCart.setTotalPrice(shoppingCart.getTotalPrice() + (currentBook.getTotalPriceInShoppingCart()));
        }
        shoppingCart.setTotalPrice(shoppingCart.getTotalPrice() + (shoppingCart.getTotalPrice() * shoppingCart.getDiscountAmount()));
    }
}
