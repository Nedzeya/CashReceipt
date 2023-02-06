import java.text.SimpleDateFormat;
import java.util.Date;


public interface HeardOfReceipt {
    String nameOfReceipt = "CASH RECEIPT";
    String nameOfShop = "SUPERMARKET 123";
    String addressOfShop = "12, MILKYWAY Galaxy/Earth";
    String telephone = "Tel :123-456-7890";
    String cashierNumber = "CASHIER: №1520";

    SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
    String date = "DATE: " + dataFormat.format(new Date());

    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    String time = "TIME: "+ timeFormat.format(new Date());

}
