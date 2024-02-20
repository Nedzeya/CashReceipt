package com.klachkova.cashReceipt.discount;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiscountTest {

    class TestDiscount implements Discount{

        @Override
        public double getPercentsOfDiscount() {
            return 10;
        }

        @Override
        public int getNumberOfDiscount() {
            return 1;
        }

        @Override
        public String getNameOfDiscount() {
            return "nameOfDiscount";
        }
    }

    Discount discount = new TestDiscount();

    @Test
    void testGetPercentsOfDiscount() {
        assertEquals(10, discount.getPercentsOfDiscount());
    }

    @Test
    void testGetNumberOfDiscount() {
        assertEquals(1, discount.getNumberOfDiscount());
    }

    @Test
    void testGetNameOfDiscount() {
        assertEquals("nameOfDiscount", discount.getNameOfDiscount());
    }



    @Test
    void testAddDiscount() {
        discount.addDiscount(discount);

        assertEquals(true, discount.getDiscountMap().containsKey(1));
    }

    @Test
    void testGetDiscountMap() {
        Map<Integer,Discount> discountMap= new HashMap<>();
        discountMap.put(1,discount);

        discount.addDiscount(discount);
        assertEquals(discountMap.containsKey(1),  discount.getDiscountMap().containsKey(1));
    }
}