package receipt;

public class ReseiptOutputInConsole implements ReceiptOutput {

    Receipt.ReceiptBuilder receiptBuilder;
    public ReseiptOutputInConsole() {

    }

    public void printInConsole (Object object) {
        this.receiptBuilder = (Receipt.ReceiptBuilder) object;
        System.out.println(this.receiptBuilder);
            }

    @Override
    public Receipt.ReceiptBuilder getReceiptBuilder() {
        return this.receiptBuilder;
    }


}
