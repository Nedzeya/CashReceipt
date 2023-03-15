package receipt.Output;

import receipt.Receipt;

import java.io.FileWriter;
import java.io.IOException;

public class ReceiptOutputInFile implements ReceiptOutput {

    Receipt.ReceiptBuilder receiptBuilder;
    public ReceiptOutputInFile() {
    }
    @Override
    public void output (Object object){
                this.receiptBuilder = (Receipt.ReceiptBuilder) object;
                String filename = "receipt_"+date+"_"+time+".txt";
                try (FileWriter writer = new FileWriter(filename, false))
                {
                    String textOfReceipt = receiptBuilder.toString();
                    writer.write(textOfReceipt);

                    writer.flush();



                } catch (IOException e) {
                    System.out.println(e.getMessage());;
                }

            }
}
