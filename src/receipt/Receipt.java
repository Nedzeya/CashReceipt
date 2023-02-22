package receipt;

import basket.Basket;
import heardOfReceipt.HeardOfReceipt;




public class Receipt {

    private HeardOfReceipt heardOfReceipt;
    private Basket basket;

    private boolean isPrintInConsole;

    private boolean isSaveInFile;


    private Receipt(ReceiptBuilder builder) {
        this.heardOfReceipt = builder.heardOfReceipt;
        this.basket = builder.basket;
        this.isPrintInConsole = builder.isPrintInConsole;
        this.isSaveInFile = builder.isSaveInFile;
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

    public boolean isPrintInConsole() {
        return isPrintInConsole;
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static class ReceiptBuilder {
        private HeardOfReceipt heardOfReceipt = new HeardOfReceipt();
        private Basket basket;

        private boolean isPrintInConsole;
        private boolean isSaveInFile;


        public ReceiptBuilder(Basket basket) {

            this.basket = basket;

        }

        public ReceiptBuilder setIsPrintInConsole(boolean isPrintInConsole) {
            this.isPrintInConsole = isPrintInConsole;
            if (isPrintInConsole) {
                System.out.println(this);
            }
            return this;

        }

        public ReceiptBuilder setIsSaveInFile (boolean isSaveInFile){
            this.isSaveInFile = isSaveInFile;
            if (isSaveInFile){

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
