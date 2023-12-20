package shoppingcart.commands;

import com.example.libirary_.Book;
import shoppingcart.ShoppingCart;

public class TotalPriceCalculator implements ShoppingCartCommand {
    public TotalPriceCalculator(){};
    @Override
    public void execute(ShoppingCart shoppingCart) {
        if (!shoppingCart.getBooks().isEmpty()) {
            Book firstBook = shoppingCart.getBooks().get(0);
            shoppingCart.setTotalPrice(firstBook.getTotalPriceInShoppingCart()-firstBook.getTotalPriceInShoppingCart()*shoppingCart.getDiscountAmount());
            for (int i = 1; i < shoppingCart.getBooks().size(); i++) {
                Book currentBook = shoppingCart.getBooks().get(i);
                shoppingCart.setTotalPrice(shoppingCart.getTotalPrice() + (currentBook.getTotalPriceInShoppingCart()-currentBook.getTotalPriceInShoppingCart()*shoppingCart.getDiscountAmount()));
            }
        }
        else{
            shoppingCart.setTotalPrice(0);
        }
    }
}
