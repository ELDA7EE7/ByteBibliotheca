package userprofile;

import librarypackage.Book;

import java.time.LocalDate;

public class Order {
    private final int orderId;
    private static int orderCounter = 0;
    private final float price;
    private final Book book;
    private final LocalDate orderDate;
    private final int quantity;

    public Order(float price, Book book, LocalDate orderDate, int quantity) {
        orderCounter++;
        this.price = price;
        this.book = book;
        this.orderDate = orderDate;
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

    public LocalDate getOrderDate() {
        return orderDate;
    }
}
