package receipt;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReceiptOutput {

    Receipt.ReceiptBuilder receiptBuilder;
    SimpleDateFormat dataFormat = new SimpleDateFormat("dd-MM-yy");
    String date = dataFormat.format(new Date());
    SimpleDateFormat timeFormat = new SimpleDateFormat("HH-mm-ss");
    String time =  timeFormat.format(new Date());
    public ReceiptOutput() {

    }

    public void printInConsole (Object object) {
        this.receiptBuilder = (Receipt.ReceiptBuilder) object;
        System.out.println(this.receiptBuilder);
            }

            public void saveInFile (Object object){
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
