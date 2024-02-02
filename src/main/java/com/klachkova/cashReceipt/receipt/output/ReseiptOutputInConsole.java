package com.klachkova.cashReceipt.receipt.output;

import com.klachkova.cashReceipt.receipt.Receipt;

public class ReseiptOutputInConsole implements ReceiptOutput {

    Receipt.ReceiptBuilder receiptBuilder;
    public ReseiptOutputInConsole() {

    }
@Override
    public void output (Object object) {
        this.receiptBuilder = (Receipt.ReceiptBuilder) object;
        System.out.println(this.receiptBuilder);
            }




}
