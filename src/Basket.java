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


    void addProduct (Product product) {

            if (!productMap.isEmpty() && productMap.containsValue(product) ){
                Product previousProduct = productMap.get(product.getIdOfProduct());
                previousProduct.setAmountOfProduct(previousProduct.getAmountOfProduct() + product.getAmountOfProduct());

                productMap.replace(product.getIdOfProduct(), previousProduct);
         }
            else {
                productMap.put(product.getIdOfProduct(), product);

         }
               }

    @Override
    public String toString (){

        StringBuilder sb = new StringBuilder(" ");
        for (Integer key : productMap.keySet()) {
            sb.append(productMap.get(key));
              }
        return String.format("%-4S %-20S %-8S %-8S\n\n","QTY","DESCRIPTION","PRICE", "TOTAL")
                + sb +
                "\n===========================================\n\n"+
                String.format("%-30S %S %.2f","TOTAL","$",totalOfBasket());
    }




}
