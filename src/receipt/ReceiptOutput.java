package receipt;

public class ReceiptOutput {

    Receipt.ReceiptBuilder receiptBuilder;

    public ReceiptOutput() {

    }

    public void printInConsole (Object object) {
        this.receiptBuilder = (Receipt.ReceiptBuilder) object;
        System.out.println(this.receiptBuilder);
            }

            public void saveInFile (Object object){
                this.receiptBuilder = (Receipt.ReceiptBuilder) object;

            }

}
