package receipt;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReceiptOutputInFile implements ReceiptOutput {


    public ReceiptOutputInFile() {
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
