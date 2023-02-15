import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {

        Actions action = new ActionSixProducts();
        Basket basket = new Basket();


        Product product = new ActionProduct(555, "hhh", 888, 9, action);
        basket.addProduct(new SimpleProduct(122, "fffggf", 22, 2));
        basket.addProduct(new ActionProduct(173, "ffeeef", 252, 7, action));
        basket.addProduct(new SimpleProduct(00, "ffgff", 282, 600));
        basket.addProduct(new SimpleProduct(8255, "ppppff", 292, 12));

        basket.addProduct(new SimpleProduct(122, "fffggf", 22, 2));
        basket.productMap.put(product.getIdOfProduct(), product);


        System.out.println(basket);
        System.out.println();

    }
}