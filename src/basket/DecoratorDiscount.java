package basket;

import basket.Basket;
import discount.Discount;

abstract class DecoratorDiscount extends Basket implements Discount {

    protected Basket basket;


    public DecoratorDiscount(Basket basket ){

        this.basket = basket;
        this.basket.productMap= basket.getProductMap();
    }




}
