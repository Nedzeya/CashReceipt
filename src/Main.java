import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {

        Actions action = new ActionSixProducts();
        Basket basket = new Basket();



basket.addProduct(new ActionProduct(555,"hhh",888,9,action));
//basket.addProduct(new SimpleProduct(122, "fffggf", 22, 2));
basket.addProduct(new ActionProduct(173, "ffeeef", 252, 7, action));
//basket.addProduct(new SimpleProduct(1255, "ffgff", 282, 6));
//basket.addProduct(new SimpleProduct(8255, "ppppff", 292, 12));

        System.out.println(basket);
    }
}