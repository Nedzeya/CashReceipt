package receipt;

public class ReseiptOutputInConsole implements ReceiptOutput {

    Receipt.ReceiptBuilder receiptBuilder;
    public ReseiptOutputInConsole() {

    }
@Override
    public void output (Object object) {
        this.receiptBuilder = (Receipt.ReceiptBuilder) object;
        System.out.println(this.receiptBuilder);
            }




}
