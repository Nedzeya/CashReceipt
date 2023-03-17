package basket;

import discount.Discount;
import product.Product;


import java.util.Map;

abstract class DecoratorDiscount extends Basket implements Discount {


    protected Map<Integer, Product> basketMap;



    public DecoratorDiscount(Map<Integer, Product> basketMap) {

        this.basketMap = basketMap;
    }
}
