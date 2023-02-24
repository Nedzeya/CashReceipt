package receipt;

import java.text.SimpleDateFormat;
import java.util.Date;

public interface ReceiptOutput {
    SimpleDateFormat dataFormat = new SimpleDateFormat("dd-MM-yy");
    String date = dataFormat.format(new Date());
    SimpleDateFormat timeFormat = new SimpleDateFormat("HH-mm-ss");
    String time = timeFormat.format(new Date());

   void output (Object object);
}
