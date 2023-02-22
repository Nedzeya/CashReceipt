package receipt;
import java.io.*;

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
                try (FileWriter writer = new FileWriter("receipt.txt", false))
                {
                    String textOfReceipt = receiptBuilder.toString();
                    writer.write(textOfReceipt);

                    writer.flush();



                } catch (IOException e) {
                    System.out.println(e.getMessage());;
                }

            }

}
