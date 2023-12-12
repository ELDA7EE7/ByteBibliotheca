package shoppingcart;

import com.example.libirary_.Book;

import java.util.List;

public interface ShoppingCartCommand {
    void execute(ShoppingCart shoppingCart);
}

class BookAdder implements ShoppingCartCommand {
    private final Book book;

    BookAdder(Book book) {
        this.book = book;
    }

    @Override
    public void execute(ShoppingCart shoppingCart) {
        book.setBookCounterInShoppingCart(book.getBookCounterInShoppingCart()+1);
        shoppingCart.getBooks().add(book);
    }
}

class BookRemover implements ShoppingCartCommand {
    private final Book book;

    BookRemover(Book book) {
        this.book = book;
    }

    @Override
    public void execute(ShoppingCart shoppingCart) {
        shoppingCart.getBooks().remove(book);
    }
}

class QuantityUpdater implements ShoppingCartCommand {
    private final Book book;
    private final int updatedQuantity;

    QuantityUpdater(Book book, int updatedQuantity) {
        this.book = book;
        this.updatedQuantity = updatedQuantity;
    }

    @Override
    public void execute(ShoppingCart shoppingCart) {
        for (Book index : shoppingCart.getBooks()) {
            if (index.getBookID() == book.getBookID()) {
                index.setBookCounterInShoppingCart(updatedQuantity);
                break;
            }
        }
    }
}

class TotalPriceCalculator implements ShoppingCartCommand {
    TotalPriceCalculator(){};
    @Override
    public void execute(ShoppingCart shoppingCart) {
        for (Book index : shoppingCart.getBooks()) {
            shoppingCart.setTotalPrice(shoppingCart.getTotalPrice() + (index.getPrice() * index.getBookCounterInShoppingCart()));
        }
    }
}

class PaymentMethodDeterminer implements ShoppingCartCommand {
    private final boolean paymentIsCash;

    PaymentMethodDeterminer(boolean paymentIsCash) {
        this.paymentIsCash = paymentIsCash;
    }
    @Override
    public void execute(ShoppingCart shoppingCart) {
        if(paymentIsCash)
            shoppingCart.setPaymentMethod("Cash");
        else
            shoppingCart.setPaymentMethod("Credit");
    }
}