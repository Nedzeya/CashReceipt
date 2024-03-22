package com.klachkova.cashReceipt.mainUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NamesFromArgTest {
    NamesFromArg names;

    @Test
    void testTakeNamesFromArgsRDPLowerCase() {
        names = new NamesFromArg(new String[]{"receiptinput", "discountcards", "products"});
        names.takeNamesFromArgs();
        assertEquals("receiptinput", names.getNameOfFileReceiptInput());
        assertEquals("discountcards", names.getNameOfDiscountCardFile());
        assertEquals("products", names.getNameOfProductsBase());

    }
    @Test
    void testTakeNamesFromArgsRDPDifCase() {
        names = new NamesFromArg(new String[]{"RECEIPTINPUT", "diScounTCards", "products"});
        names.takeNamesFromArgs();
        assertEquals("RECEIPTINPUT", names.getNameOfFileReceiptInput());
        assertEquals("diScounTCards", names.getNameOfDiscountCardFile());
        assertEquals("products", names.getNameOfProductsBase());

    }

    @Test
    void testTakeNamesFromArgsRDPDifCaseExtraLetters() {
        names = new NamesFromArg(new String[]{"RECEIPTINPUTq", "diScounTCardswer", "prodALLOURucts"});
        names.takeNamesFromArgs();
        assertEquals("RECEIPTINPUTq", names.getNameOfFileReceiptInput());
        assertEquals("diScounTCardswer", names.getNameOfDiscountCardFile());
        assertEquals("", names.getNameOfProductsBase());

    }

    @Test
    void testTakeNamesFromArgsDP() {
        names = new NamesFromArg(new String[]{"diScounTCardswer", "prodALLOURucts"});
        names.takeNamesFromArgs();
        assertEquals("", names.getNameOfFileReceiptInput());
        assertEquals("diScounTCardswer", names.getNameOfDiscountCardFile());
        assertEquals("", names.getNameOfProductsBase());

    }
    @Test
    void testTakeNamesFromArgsOnlyProducts() {
        names = new NamesFromArg(new String[]{ "products"});
        names.takeNamesFromArgs();
        assertEquals("", names.getNameOfFileReceiptInput());
        assertEquals("", names.getNameOfDiscountCardFile());
        assertEquals("products", names.getNameOfProductsBase());

    }
    @Test
    void testTakeNamesFromArgsEmpty() {
        names = new NamesFromArg(new String[]{});
        names.takeNamesFromArgs();
        assertEquals("", names.getNameOfFileReceiptInput());
        assertEquals("", names.getNameOfDiscountCardFile());
        assertEquals("", names.getNameOfProductsBase());

    }

    @Test
    void testTakeNamesFromArgsInappropriateWords() {
        names = new NamesFromArg(new String[]{"inappropriate", "irrelevant","misplaced"});
        names.takeNamesFromArgs();
        assertEquals("", names.getNameOfFileReceiptInput());
        assertEquals("", names.getNameOfDiscountCardFile());
        assertEquals("", names.getNameOfProductsBase());

    }

    @Test
    void testTakeNamesFromArgsNumbers() {
        names = new NamesFromArg(new String[]{"1", "2","3"});
        names.takeNamesFromArgs();
        assertEquals("", names.getNameOfFileReceiptInput());
        assertEquals("", names.getNameOfDiscountCardFile());
        assertEquals("", names.getNameOfProductsBase());

    }

    @Test
    void testTakeNamesFromArgsNull() {
        names = new NamesFromArg(new String[]{null, " ","3"});
        names.takeNamesFromArgs();
        assertEquals("", names.getNameOfFileReceiptInput());
        assertEquals("", names.getNameOfDiscountCardFile());
        assertEquals("", names.getNameOfProductsBase());

    }
}
