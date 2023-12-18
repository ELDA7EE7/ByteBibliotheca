package userprofile;

import com.example.libirary_.Book;

public class Order {
    private final int orderId;
    private static int orderCounter = 0;
    private final float price;
    private final Book book;
    private final int quantity;

    public Order(float price, Book book, int quantity) {
        orderCounter++;
        this.price = price;
        this.book = book;
        this.quantity = quantity;
        this.orderId = orderCounter;
    }

    public int getOrderId() {
        return orderId;
    }

    public float getPrice() {
        return price;
    }


    public Book getBook() {
        return book;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return
                "Order Id = " + orderId +
                        "      price =" + price +
                        "      book Title = " + book.getTitle() +
                        "      quantity = " + quantity
                ;
    }
}
