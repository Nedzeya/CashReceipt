import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {

        Discount discount  = new DiscountCard(0.4,1);

        ProductFactory productFactory = new ProductFactory();
        Basket basket = new DiscountCardBasket (new Basket(), 1);



       basket.addProduct(productFactory.createActionSixProduct(555, "hhh", 888, 9));

        basket.addProduct(productFactory.createActionSixProduct(173, "ffeeef", 252, 7));



        System.out.println(basket);


    }
}