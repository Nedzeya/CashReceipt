import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



public class Main {
    public static void main(String[] args) {

        Actions action = new ActionSixProducts();
        Map<Integer, Product> productMap = new HashMap<Integer, Product>();

        productMap.put(122, new SimpleProduct(122, "fffggf", 22, 2));
        productMap.put(1255, new SimpleProduct(1255, "ffgff", 282, 6));
        productMap.put(173, new ActionProduct(173, "ffeeef", 252, 7, action));

        StringBuilder sb = new StringBuilder("\n");
        for (Map.Entry<Integer, Product> entry : productMap.entrySet()) {
            Product value = entry.getValue();
           sb.append(value)

                    .append("\n");

        }
        System.out.println(sb);
    }
}