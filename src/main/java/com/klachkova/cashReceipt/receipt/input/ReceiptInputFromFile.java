package com.klachkova.cashReceipt.receipt.input;

import com.klachkova.cashReceipt.readerFromFile.ReaderFromFileIntoStringArray;
import com.klachkova.cashReceipt.readerFromFile.ReaderFromFileIntoStringArraySplitSpace;

public class ReceiptInputFromFile implements ReceiptInput {
    public ReceiptInputFromFile() {
    }

    @Override
    public String[] input(String nameOfFile) {

        ReaderFromFileIntoStringArray readerFromFile = new ReaderFromFileIntoStringArraySplitSpace();
        return readerFromFile.readFromFile(nameOfFile);
    }

}
