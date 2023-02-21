package basket;

import product.Product;

import java.util.*;

public class Basket {

   public Map<Integer, Product> productMap= new HashMap<>();
    public Basket() {

    }

    public Basket(Product product) {

        addProduct(product);

    }

   public double totalOfBasket() {

        Set<Integer> keys = getProductMap().keySet();

        double result = 0;
        for (Integer key : keys) {
            result += getProductMap().get(key).totalPriceOfProduct();
        }

        return result;
    }


    public void addProduct(Product product) {

            if (!productMap.isEmpty() && productMap.containsValue(product) ){
                Product previousProduct = productMap.get(product.getIdOfProduct());
                previousProduct.setAmountOfProduct(previousProduct.getAmountOfProduct() + product.getAmountOfProduct());

                productMap.replace(product.getIdOfProduct(), previousProduct);

                System.out.println("the same pr was added");
         }
            else {
                productMap.put(product.getIdOfProduct(), product);

                System.out.println("new pr was added");

         }
               }

    @Override
    public String toString (){

        StringBuilder sb = new StringBuilder(" ");
        for (Integer key : getProductMap().keySet()) {
            sb.append(getProductMap().get(key));
              }
        return String.format("%-4S %-20S %-8S %-8S\n\n","QTY","DESCRIPTION","PRICE", "TOTAL")
                + sb +
                "\n===========================================\n\n"+
                String.format("%-30S %S %.2f","TOTAL","$",totalOfBasket());
    }

    public Map<Integer, Product> getProductMap() {
        return productMap;
    }
}
