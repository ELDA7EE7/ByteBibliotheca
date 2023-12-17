package shoppingcart;

import com.example.libirary_.Book;
import shoppingcart.commands.*;

import java.util.List;

public class ShoppingCart {
    private List<Book> books;
    private List<Discount> discounts;
    private String paymentMethod;
    private float totalPrice;
    private float discountAmount;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public float getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(float discountAmount) {
        this.discountAmount = discountAmount;
    }

    public void addBook(Book book) {
        BookAdder bookAdder = new BookAdder(book);
        bookAdder.execute(this);
    }

    public void removeBook(Book book) {
        BookRemover bookRemover = new BookRemover(book);
        bookRemover.execute(this);
    }

    public void determinePaymentMethod(boolean paymentIsCash) {
        PaymentMethodDeterminer paymentMethodDeterminer = new PaymentMethodDeterminer(paymentIsCash);
        paymentMethodDeterminer.execute(this);
    }

    public void updateQuantity(Book book, int updatedQuantity) {
        QuantityUpdater quantityUpdater = new QuantityUpdater(book, updatedQuantity);
        quantityUpdater.execute(this);
    }

    public void calculateBookPrice() {
        BookPriceCalculator bookPriceCalculator = new BookPriceCalculator();
        bookPriceCalculator.execute(this);
    }

    public void calculateTotalPrice() {
        TotalPriceCalculator totalPriceCalculator = new TotalPriceCalculator();
        totalPriceCalculator.execute(this);
    }
}
