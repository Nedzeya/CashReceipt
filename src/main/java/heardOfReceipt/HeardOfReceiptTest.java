package heardOfReceipt;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HeardOfReceiptTest {

    HeardOfReceipt heardOfReceipt = new HeardOfReceipt();
    @Test
    void testToString() {
        String nameOfReceipt = "CASH RECEIPT";
        String nameOfShop = "SUPERMARKET 123";
        String addressOfShop = "12, MILKYWAY Galaxy/Earth";
        String telephone = "Tel :123-456-7890";
        String cashierNumber = "CASHIER: #1520";

        SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = "DATE: " + dataFormat.format(new Date());

        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String time = "TIME: "+ timeFormat.format(new Date());

        assertEquals(String.format("%35S\n %35s\n %40s\n %35s\n %-35S %S\n %50S\n %s",
                nameOfReceipt,nameOfShop,addressOfShop, telephone,cashierNumber,date,time,
                "____________________________________________________\n\n"),heardOfReceipt.toString());
    }

    @Test
    void testGetDate() {
        SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = "DATE: " + dataFormat.format(new Date());

        assertEquals(date, heardOfReceipt.getDate()) ;
    }

    @Test
    void testGetTime() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String time = "TIME: "+ timeFormat.format(new Date());

        assertEquals(time, heardOfReceipt.getTime()) ;
    }
}