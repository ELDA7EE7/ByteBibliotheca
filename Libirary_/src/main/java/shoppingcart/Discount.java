package shoppingcart;

public class Discount {
    private String promoCode;
    private float discountPercentage;
    private boolean usedByUser;
    public Discount(String promoCode, float discountPercentage){
        this.promoCode=promoCode;
        this.discountPercentage=discountPercentage;
    }
    
    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public float getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(float discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public boolean isUsedByUser() {
        return usedByUser;
    }

    public void setUsedByUser(boolean usedByUser) {
        this.usedByUser = usedByUser;
    }
}
