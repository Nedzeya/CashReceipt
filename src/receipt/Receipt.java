package receipt;

import basket.Basket;
import basket.DiscountCardBasket;
import heardOfReceipt.HeardOfReceipt;
import product.Product;

import java.util.HashMap;
import java.util.Map;

public class Receipt {

    private HeardOfReceipt heardOfReceipt = new HeardOfReceipt();
    private Basket basket = new Basket();


    private DiscountCardBasket discountCardBasket;
    private boolean isDiscountCardSubmitted;


    private Receipt(ReceiptBuilder builder) {
        this.heardOfReceipt = heardOfReceipt;
        this.basket = basket;
        this.isDiscountCardSubmitted = isDiscountCardSubmitted;
    }

    public HeardOfReceipt getHeardOfReceipt() {
        return heardOfReceipt;
    }

    public Basket getBasket() {
        return basket;
    }

    public boolean isDiscountCardSubmitted() {
        return isDiscountCardSubmitted;
    }

    @Override
    public String toString() {
        return heardOfReceipt.toString() + basket.toString();
    }


    public static class ReceiptBuilder {


        Map<Integer, Product> productMap = new HashMap<>();
        private final Basket basket;
        private DiscountCardBasket discountCardBasket;
        private boolean isDiscountCardSubmitted;

        public ReceiptBuilder(Basket basket) {
            this.basket = basket;
            this.productMap = basket.getProductMap();

        }

//        public ReceiptBuilder(void addProduct) {
//
//        }


        public ReceiptBuilder setDiscountCardSubmitted(boolean isDiscountCardSubmitted) {
            this.isDiscountCardSubmitted = isDiscountCardSubmitted;
            return this;
        }

        public Receipt build() {
            return new Receipt(this);
        }
    }
}