package receipt;

import basket.Basket;
import heardOfReceipt.HeardOfReceipt;




public class Receipt {

    private HeardOfReceipt heardOfReceipt;
    private Basket basket;
    private ReceiptOutput receiptOutput;


    private Receipt(ReceiptBuilder builder) {
        this.heardOfReceipt = builder.heardOfReceipt;
        this.basket = builder.basket;
        this.receiptOutput = builder.receiptOutput;


    }

    public HeardOfReceipt getHeardOfReceipt() {

        return heardOfReceipt;
    }

    public Basket getBasket() {
        return basket;
    }

    @Override
    public String toString() {
        return getHeardOfReceipt().toString()
                + getBasket().toString();
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static class ReceiptBuilder {
        private HeardOfReceipt heardOfReceipt = new HeardOfReceipt();
        private Basket basket;

        private ReceiptOutput receiptOutput = new ReceiptOutput();


        public ReceiptBuilder(Basket basket) {

            this.basket = basket;

        }

        public ReceiptBuilder setIsPrintInConsole(boolean isPrintInConsole) {
            if (isPrintInConsole) {
                receiptOutput.printInConsole(this);
            }
            return this;

        }

        public ReceiptBuilder setIsSaveInFile (boolean isSaveInFile){
            if (isSaveInFile){
                receiptOutput.saveInFile(this);
            }

            return this;
        }


        public Receipt build() {

            return new Receipt(this);
        }

        @Override
        public String toString() {
            return heardOfReceipt.toString()
                    + basket.toString();
        }

    }

}
