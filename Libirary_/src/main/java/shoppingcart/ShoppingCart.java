package shoppingcart;

import com.example.libirary_.Book;

import java.util.List;

public class ShoppingCart {
    private List<Book> books;
    private String paymentMethod;
    private float totalPrice;
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
    public void addBook(Book book){
        BookAdder bookAdder = new BookAdder(book);
        bookAdder.execute(this);
    }
    public void removeBook(Book book){
        BookRemover bookRemover = new BookRemover(book);
        bookRemover.execute(this);
    }
    public void calculateTotalPrice(){
        TotalPriceCalculator totalPriceCalculator = new TotalPriceCalculator();
        totalPriceCalculator.execute(this);
    }
    public void determinePaymentMethod(boolean paymentIsCash){
        PaymentMethodDeterminer paymentMethodDeterminer = new PaymentMethodDeterminer(paymentIsCash);
        paymentMethodDeterminer.execute(this);
    }
}
