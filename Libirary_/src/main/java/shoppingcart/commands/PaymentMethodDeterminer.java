package shoppingcart.commands;

import shoppingcart.ShoppingCart;

public class PaymentMethodDeterminer implements ShoppingCartCommand {
    private final boolean paymentIsCash;
    public PaymentMethodDeterminer(boolean paymentIsCash) {
        this.paymentIsCash = paymentIsCash;
    }
    @Override
    public void execute(ShoppingCart shoppingCart) {
        if(paymentIsCash)
            shoppingCart.setPaymentMethod("Cash on Delivery");
        else
            shoppingCart.setPaymentMethod("Credit");
    }
}
