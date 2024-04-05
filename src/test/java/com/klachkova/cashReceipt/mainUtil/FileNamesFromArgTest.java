package com.klachkova.cashReceipt.mainUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileNamesFromArgTest {
    FileNamesFromArg names;

    @Test
    void testTakeNamesFromArgsRDPLowerCase() {
        names = new FileNamesFromArg(new String[]{"receiptinput", "discountcards", "products"});
        names.takeNamesFromArgs();
        assertEquals("receiptinput", names.getNameOfFileReceiptInput());
        assertEquals("discountcards", names.getNameOfDiscountCardFile());
        assertEquals("products", names.getNameOfProductsBase());

    }
    @Test
    void testTakeNamesFromArgsRDPDifCase() {
        names = new FileNamesFromArg(new String[]{"RECEIPTINPUT", "diScounTCards", "products"});
        names.takeNamesFromArgs();
        assertEquals("RECEIPTINPUT", names.getNameOfFileReceiptInput());
        assertEquals("diScounTCards", names.getNameOfDiscountCardFile());
        assertEquals("products", names.getNameOfProductsBase());

    }

    @Test
    void testTakeNamesFromArgsRDPDifCaseExtraLetters() {
        names = new FileNamesFromArg(new String[]{"RECEIPTINPUTq", "diScounTCardswer", "prodALLOURucts"});
        names.takeNamesFromArgs();
        assertEquals("RECEIPTINPUTq", names.getNameOfFileReceiptInput());
        assertEquals("diScounTCardswer", names.getNameOfDiscountCardFile());
        assertEquals("", names.getNameOfProductsBase());

    }

    @Test
    void testTakeNamesFromArgsDP() {
        names = new FileNamesFromArg(new String[]{"diScounTCardswer", "prodALLOURucts"});
        names.takeNamesFromArgs();
        assertEquals("", names.getNameOfFileReceiptInput());
        assertEquals("diScounTCardswer", names.getNameOfDiscountCardFile());
        assertEquals("", names.getNameOfProductsBase());

    }
    @Test
    void testTakeNamesFromArgsOnlyProducts() {
        names = new FileNamesFromArg(new String[]{ "products"});
        names.takeNamesFromArgs();
        assertEquals("", names.getNameOfFileReceiptInput());
        assertEquals("", names.getNameOfDiscountCardFile());
        assertEquals("products", names.getNameOfProductsBase());

    }
    @Test
    void testTakeNamesFromArgsEmpty() {
        names = new FileNamesFromArg(new String[]{});
        names.takeNamesFromArgs();
        assertEquals("", names.getNameOfFileReceiptInput());
        assertEquals("", names.getNameOfDiscountCardFile());
        assertEquals("", names.getNameOfProductsBase());

    }

    @Test
    void testTakeNamesFromArgsInappropriateWords() {
        names = new FileNamesFromArg(new String[]{"inappropriate", "irrelevant","misplaced"});
        names.takeNamesFromArgs();
        assertEquals("", names.getNameOfFileReceiptInput());
        assertEquals("", names.getNameOfDiscountCardFile());
        assertEquals("", names.getNameOfProductsBase());

    }

    @Test
    void testTakeNamesFromArgsNumbers() {
        names = new FileNamesFromArg(new String[]{"1", "2","3"});
        names.takeNamesFromArgs();
        assertEquals("", names.getNameOfFileReceiptInput());
        assertEquals("", names.getNameOfDiscountCardFile());
        assertEquals("", names.getNameOfProductsBase());

    }

    @Test
    void testTakeNamesFromArgsNull() {
        names = new FileNamesFromArg(new String[]{null, " ","3"});
        names.takeNamesFromArgs();
        assertEquals("", names.getNameOfFileReceiptInput());
        assertEquals("", names.getNameOfDiscountCardFile());
        assertEquals("", names.getNameOfProductsBase());

    }
}
