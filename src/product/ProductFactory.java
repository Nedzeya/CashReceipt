package product;

import actions.ActionSixProducts;
import actions.Actions;
import product.ActionProduct;
import product.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductFactory {

    Actions action = new ActionSixProducts();
    Map<Integer, Product> productMap = new HashMap<>();
    public Product createSimpleProduct(int IdOfProduct, String nameOfProduct, double priceOfProduct) {
        Product product = new SimpleProduct(IdOfProduct, nameOfProduct, priceOfProduct);
        productMap.putIfAbsent(product.getIdOfProduct(),product);
        return product;
    }

   public Product createActionSixProduct(int IdOfProduct, String nameOfProduct, double priceOfProduct) {
       Product product = new ActionProduct(IdOfProduct, nameOfProduct, priceOfProduct, this.action);
       productMap.putIfAbsent(product.getIdOfProduct(),product);
        return product;
    }

    public Map<Integer, Product> getProductMap() {
        return productMap;
    }
}

