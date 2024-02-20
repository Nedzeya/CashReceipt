package com.klachkova.cashReceipt.receipt;

import basket.Basket;
import com.klachkova.cashReceipt.heardOfReceipt.HeardOfReceipt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReceiptTest {
    Receipt receipt = new Receipt();
    HeardOfReceipt expectedHeardOfReceipt = new HeardOfReceipt();
    Basket basket = new Basket();
    @Test
    void testGetHeardOfReceipt() {

        receipt.setHeardOfReceipt(expectedHeardOfReceipt);

        HeardOfReceipt actualHeardOfReceipt = receipt.getHeardOfReceipt();

        assertEquals(expectedHeardOfReceipt, actualHeardOfReceipt);

    }

    @Test
    void testGetBasket() {
        receipt.setBasket(basket);
        assertEquals(basket,receipt.getBasket());
    }

    @Test
    void testToString() {
        receipt.setHeardOfReceipt(expectedHeardOfReceipt);
        receipt.setBasket(basket);
        assertEquals(expectedHeardOfReceipt.toString()+basket.toString(),receipt.toString());
    }
}