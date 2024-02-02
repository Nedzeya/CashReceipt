package com.klachkova.cashReceipt.discount;

import org.junit.jupiter.api.Test;

class DiscountCardTest {


    @Test
    void testGetPositivePercentsOfDiscount() {
       double percentsOfDiscount = 10.5;
       int numberOfDiscount = 1;
        DiscountCard discountCard = new DiscountCard(percentsOfDiscount,numberOfDiscount);
        assertEquals(10.5,discountCard.getPercentsOfDiscount());
    }
    @Test
    void testGetNegativePercentsOfDiscount() {
        double percentsOfDiscount = -10.5;
        int numberOfDiscount = 1;
        DiscountCard discountCard = new DiscountCard(percentsOfDiscount,numberOfDiscount);
        assertEquals(10.5,discountCard.getPercentsOfDiscount());
    }
    @Test
    void testGetZeroPercentsOfDiscount() {
        double percentsOfDiscount = 0;
        int numberOfDiscount = 1;
        DiscountCard discountCard = new DiscountCard(percentsOfDiscount,numberOfDiscount);
        assertEquals(0,discountCard.getPercentsOfDiscount());
    }

    @Test
    void testGetPositiveNumberOfDiscount() {
        double percentsOfDiscount = 10.5;
        int numberOfDiscount = 1;
        DiscountCard discountCard = new DiscountCard(percentsOfDiscount,numberOfDiscount);
        assertEquals(1,discountCard.getNumberOfDiscount());

    }

    @Test
    void testGetNegativeNumberOfDiscount() {
        double percentsOfDiscount = 10.5;
        int numberOfDiscount = -1;
        DiscountCard discountCard = new DiscountCard(percentsOfDiscount,numberOfDiscount);
        assertEquals(1,discountCard.getNumberOfDiscount());

    }
    @Test
    void testGetZeroNumberOfDiscount() {
        double percentsOfDiscount = 10.5;
        int numberOfDiscount = 0;
        DiscountCard discountCard = new DiscountCard(percentsOfDiscount,numberOfDiscount);
        assertEquals(0,discountCard.getNumberOfDiscount());

    }

    @Test
    void testGetNameOfDiscount() {
        double percentsOfDiscount = 10.5;
        int numberOfDiscount = 0;
        DiscountCard discountCard = new DiscountCard(percentsOfDiscount,numberOfDiscount);
        assertEquals("DiscountCardOfClient",discountCard.getNameOfDiscount());
    }
}