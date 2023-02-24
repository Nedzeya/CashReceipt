package basket;

import discount.Discount;
import product.Product;

import java.util.HashMap;
import java.util.Map;

abstract class DecoratorDiscount extends Basket implements Discount {

 //   protected Basket basket;
    protected Map<Integer, Product> basketMap;



//    public DecoratorDiscount(Basket basket ){
//
//        this.basket = basket;
//        this.basketMap = this.basket.getBasketMap();
//    }

    public DecoratorDiscount(Map<Integer, Product> basketMap) {
        this.basketMap = basketMap;
    }
}
