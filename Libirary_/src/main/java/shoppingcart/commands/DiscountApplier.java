package shoppingcart.commands;

import javafx.scene.control.Alert;
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
                if(currentDiscount.isUsedByUser()){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Discount is Used");
                    alert.setHeaderText("You entered an already used Promo Code.");
                    alert.setContentText("Enter an unused Promo Code, please.");
                    alert.showAndWait();
                }
                else{
                shoppingCart.setDiscountAmount(currentDiscount.getDiscountPercentage());
                }
                break;
            }
        }
        if(!discountFound){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Code");
            alert.setHeaderText("You entered an Invalid Promo Code.");
            alert.setContentText("Enter an Existing Promo Code, please.");
            alert.showAndWait();
        }
    }
}
