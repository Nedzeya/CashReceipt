import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {

        Discount discount = new DiscountCard();
        discount.addDiscount(new DiscountCard(0.4, 1));
        discount.addDiscount(new DiscountCard(0.1, 2));


        ProductFactory productFactory = new ProductFactory();
        //Basket basket = new Basket ();
        Basket basket = new DiscountCardBasket(new Basket(), 2);


        basket.addProduct(productFactory.createActionSixProduct(555, "hhh", 888, 1));

        basket.addProduct(productFactory.createActionSixProduct(173, "ffeeef", 2, 21));



        System.out.println(basket);


    }
}