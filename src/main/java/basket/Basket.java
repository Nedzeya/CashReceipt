package basket;

import com.klachkova.cashReceipt.product.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Basket {

   public Map<Integer, Product> basketMap = new HashMap<>();
    public Basket() {

    }



   public double totalOfBasket() {

        Set<Integer> keys = getBasketMap().keySet();

        double result = 0;
        for (Integer key : keys) {
            result += getBasketMap().get(key).totalPriceOfProduct();
        }

        return result;
    }


    public void addProduct(Product product) {
        basketMap.put(product.getIdOfProduct(), product);

    }

    @Override
    public String toString (){

        StringBuilder sb = new StringBuilder(" ");
        for (Integer key : getBasketMap().keySet()) {
            sb.append(getBasketMap().get(key));
              }
        return String.format("%-4S %-20S %-8S %-8S\n\n","QTY","DESCRIPTION","PRICE", "TOTAL")
                + sb +
                "\n===========================================\n\n"+
                String.format("%-30S %S %.2f","TOTAL","$",totalOfBasket());
    }

    public Map<Integer, Product> getBasketMap() {
        return basketMap;
    }
}
