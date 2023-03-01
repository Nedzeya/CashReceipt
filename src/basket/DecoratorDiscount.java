package basket;

import discount.Discount;
import product.Product;

import java.util.Map;

abstract class DecoratorDiscount extends Basket implements Discount {


    protected Map<Integer, Product> basketMap;

    protected Basket basket;

    public DecoratorDiscount(Map<Integer, Product> basketMap) {

        this.basketMap = basketMap;
    }


    @Override
    public double totalOfBasket() {
        return basket.totalOfBasket();
    }

    @Override
    public String toString() {
        return basket.toString();
    }
}
