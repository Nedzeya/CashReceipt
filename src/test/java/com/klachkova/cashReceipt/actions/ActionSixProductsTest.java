package com.klachkova.cashReceipt.actions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ActionSixProductsTest {

    Actions action = new ActionSixProducts();

    @Test
    void testGetNameOfActionSixProducts() {

        assertEquals("Six products",action.getNameOfAction());
    }

    @Test
    void testGetPercentsOfActionSixProducts() {
        assertEquals(10,action.getPercents());
    }

    @Test
    void TestGetCountOfProductOfActionSixProducts() {
        assertEquals(6,action.getCountOfProduct());
    }
}