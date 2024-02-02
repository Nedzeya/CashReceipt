package com.klachkova.cashReceipt.receipt.input;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptInputTest {
    String nameOfFileReceiptInput;
    String[] strings = {"test"};
    class TestReceiptInput implements ReceiptInput{

        @Override
        public String[] input(String nameOfFileReceiptInput) {
            return strings ;
        }
    }
    @Test
    void testInput() {
        ReceiptInput receiptInput = new TestReceiptInput();
        assertEquals(strings,receiptInput.input(nameOfFileReceiptInput));
    }
}