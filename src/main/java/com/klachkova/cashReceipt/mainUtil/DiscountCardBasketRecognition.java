package com.klachkova.cashReceipt.mainUtil;

import com.klachkova.cashReceipt.basket.Basket;
import com.klachkova.cashReceipt.basket.DiscountCardBasket;
import com.klachkova.cashReceipt.discount.Discount;

public class DiscountCardBasketRecognition {
    Basket basket;
    Discount discount;
    Integer numberOfCard;

    public DiscountCardBasketRecognition(Basket basket, Discount discount, Integer numberOfCard) {
        this.basket = basket;
        this.discount = discount;
        this.numberOfCard = numberOfCard;
    }

    public Basket toRecogniseADiscountCard() {
        try {
            if (discount.getDiscountMap().containsKey(numberOfCard)) {
                return new DiscountCardBasket(basket.getBasketMap(), numberOfCard);
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            System.out.println("incorrect number of card");
        }
        return basket;
    }
}
