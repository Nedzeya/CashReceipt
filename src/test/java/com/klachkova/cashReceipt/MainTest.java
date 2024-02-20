package com.klachkova.cashReceipt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    Main main = new Main();

    //args[4]="qqq";
    //        args[4]=" ";

    @Test
    void testInputArgsOfProducts() {
        String[] args = new String[6];
        args[0]="products.txt";
        args[1]="2-1";
        args[2]="3-1";
        args[3]="card-2";
        args[4]="discountCards.txt";
        args[5]="1-100";
        assertDoesNotThrow(() -> main.main(args), "The main method should not throw any exceptions.");
    }
}
