package userprofile;

import librarypackage.Book;

import java.time.LocalDate;

public class Order {
    private final int orderId;
    private static int orderCounter = 0;
    private final float price;
    private final LocalDate orderDate;
    private final int quantity;

    public Order(float price, LocalDate orderDate, int quantity) {
        orderCounter++;
        this.price = price;
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



    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return
                "Order Id = " + orderId +
                        "      price =" + price +
                        "      quantity = " + quantity
                ;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }
}
