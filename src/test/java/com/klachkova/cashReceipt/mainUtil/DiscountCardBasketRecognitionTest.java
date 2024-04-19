package com.klachkova.cashReceipt.mainUtil;

import com.klachkova.cashReceipt.basket.Basket;
import com.klachkova.cashReceipt.basket.DiscountCardBasket;
import com.klachkova.cashReceipt.discount.Discount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiscountCardBasketRecognitionTest {

    @Test

    public void testCardRecognition_CorrectCard_ReturnsDiscountCardBasket() {
        Basket basket = new Basket();
        Discount discount = new Discount() {
            @Override
            public double getPercentsOfDiscount() {
                return 10;
            }

            @Override
            public int getNumberOfDiscount() {
                return 100;
            }

            @Override
            public String getNameOfDiscount() {
                return "10% Discount";
            }

        };

        int numberOfCard = 100;

        DiscountCardBasketRecognition cardBasketRecognition
                = new DiscountCardBasketRecognition(basket, discount, numberOfCard);
        //?
        DiscountCardBasket result = (DiscountCardBasket) cardBasketRecognition.toRecogniseADiscountCard();


        assertTrue(result instanceof DiscountCardBasket);
        assertEquals(result.getNameOfDiscount(), "10% Discount");

    }
}
