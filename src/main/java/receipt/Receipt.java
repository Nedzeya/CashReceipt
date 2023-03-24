package receipt;

import basket.Basket;
import heardOfReceipt.HeardOfReceipt;
import receipt.Output.ReceiptOutput;
import receipt.Output.ReceiptOutputInFile;
import receipt.Output.ReseiptOutputInConsole;

public class Receipt {

    private HeardOfReceipt heardOfReceipt;
    private Basket basket;
    private ReceiptOutput output;


    // for UTests////////////////////////
    public Receipt() {
    }

    public void setHeardOfReceipt(HeardOfReceipt heardOfReceipt) {
        this.heardOfReceipt = heardOfReceipt;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    ////////////////////////////////////////////////////////////////////////////
    private Receipt(ReceiptBuilder builder) {
        this.heardOfReceipt = builder.heardOfReceipt;
        this.basket = builder.basket;
        this.output = builder.output;


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

        private ReceiptOutput output;


        public ReceiptBuilder(Basket basket) {

            this.basket = basket;

        }

        public ReceiptBuilder setIsPrintInConsole(boolean isPrintInConsole) {
            if (isPrintInConsole) {
                output = new ReseiptOutputInConsole();
                output.output(this);
            }
            return this;

        }

        public ReceiptBuilder setIsSaveInFile (boolean isSaveInFile){
            if (isSaveInFile){
                output = new ReceiptOutputInFile();
               output.output(this);
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
