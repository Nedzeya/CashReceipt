import java.util.HashMap;
import java.util.Map;

abstract class DecoratorDiscount extends Basket implements Discount {

    protected Basket basket;


    public DecoratorDiscount(Basket basket ){

        this.basket = basket;
        this.productMap = basket.productMap;
    }




}
