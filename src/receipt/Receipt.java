package receipt;

import basket.Basket;
import basket.DiscountCardBasket;
import heardOfReceipt.HeardOfReceipt;
import product.Product;



public class Receipt {

    private HeardOfReceipt heardOfReceipt ;
    private Basket basket;
    private DiscountCardBasket discountCardBasket;
    private boolean isDiscountCardSubmitted;


    private Receipt(ReceiptBuilder builder) {
        this.heardOfReceipt = builder.heardOfReceipt;
        this.basket = builder.basket;
        this.isDiscountCardSubmitted = builder.isDiscountCardSubmitted;
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
        return getHeardOfReceipt().toString()
                + getBasket().toString();
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static class ReceiptBuilder {
        private HeardOfReceipt heardOfReceipt= new HeardOfReceipt();
        private Basket basket;



        //private DiscountCardBasket discountCardBasket;

        private boolean isDiscountCardSubmitted;

        public ReceiptBuilder(Product product) {
            this.heardOfReceipt = new HeardOfReceipt();
            this.basket = new Basket(product);

            System.out.println("new receipt was biulded");
        }

        public ReceiptBuilder(Basket basket) {
            this.basket = basket;

        }

        public ReceiptBuilder setDiscountCardSubmitted(boolean isDiscountCardSubmitted) {
            this.isDiscountCardSubmitted = isDiscountCardSubmitted;
            return this;
        }

        public Receipt build() {

            return new Receipt(this);
        }

    }

}
