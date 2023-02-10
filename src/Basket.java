import java.util.*;

public class Basket {
    Map<Integer, Product> productMap = new HashMap<Integer, Product>();

    public Basket() {
    }

    double totalOfBasket() {

        Set<Integer> keys = productMap.keySet();

        double result = 0;
        for (Integer key : keys) {
            result += productMap.get(key).totalPriceOfProduct();
        }

        return result;
    }

    boolean addProduct (Product product) {

        if (product.isEmpty()) {
            return false;
        }
        if (productMap.containsKey(product.getIdOfProduct())) {
            Product previousProduct = productMap.get(product.getIdOfProduct());
            previousProduct.setAmountOfProduct(previousProduct.getAmountOfProduct() + product.getAmountOfProduct());

            productMap.replace(product.getIdOfProduct(), previousProduct);
        } else {
            productMap.put(product.getIdOfProduct(), product);
        }
        return true;
    }

    @Override
    public String toString (){

        Set<Integer> keys = productMap.keySet();

        for (Integer key : keys) {
       return productMap.get(key).toString();
        }

        return null;
    }




}
