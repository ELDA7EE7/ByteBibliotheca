package shoppingcart.commands;

import shoppingcart.Discount;
import shoppingcart.ShoppingCart;

public class DiscountApplier implements ShoppingCartCommand {
    private final String promoCode;
    public DiscountApplier (String promoCode){
        this.promoCode=promoCode;
    }
    @Override
    public void execute(ShoppingCart shoppingCart) {
        boolean discountFound = false;
        for (Discount currentDiscount : shoppingCart.getDiscounts()) {
            if (currentDiscount.getPromoCode().equals(this.promoCode)) {
                discountFound=true;
                shoppingCart.setDiscountAmount(currentDiscount.getDiscountPercentage());
                break;
            }
        }
        if(!discountFound){
            //print invalid promo code alert in scene
        }
    }
}
