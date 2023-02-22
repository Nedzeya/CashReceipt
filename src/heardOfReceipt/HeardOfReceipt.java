package heardOfReceipt;

import java.text.SimpleDateFormat;
import java.util.Date;


public class HeardOfReceipt {
    String nameOfReceipt = "CASH RECEIPT";
    String nameOfShop = "SUPERMARKET 123";
    String addressOfShop = "12, MILKYWAY Galaxy/Earth";
    String telephone = "Tel :123-456-7890";
    String cashierNumber = "CASHIER: №1520";

    SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
    String date = "DATE: " + dataFormat.format(new Date());

    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    String time = "TIME: "+ timeFormat.format(new Date());

    public HeardOfReceipt() {
        this.nameOfReceipt = nameOfReceipt;
        this.nameOfShop = nameOfShop;
        this.addressOfShop = addressOfShop;
        this.telephone = telephone;
        this.cashierNumber = cashierNumber;
        this.date = date;
        this.time = time;
    }

    @Override
    public String toString() {
        return String.format("%35S\n %35s\n %40s\n %35s\n %-35S %S\n %50S\n %s",
                nameOfReceipt,nameOfShop,addressOfShop, telephone,cashierNumber,date,time,
                "____________________________________________________\n\n");
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
