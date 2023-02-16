package product;

import actions.ActionSixProducts;
import actions.Actions;
import product.ActionProduct;
import product.Product;

public class ProductFactory {

    Actions action = new ActionSixProducts();
    public Product createSimpleProduct(int IdOfProduct, String nameOfProduct, double priceOfProduct, int amountOfProduct) {
        return new SimpleProduct(IdOfProduct, nameOfProduct, priceOfProduct, amountOfProduct);
    }

   public Product createActionSixProduct(int IdOfProduct, String nameOfProduct, double priceOfProduct, int amountOfProduct) {
        return new ActionProduct(IdOfProduct, nameOfProduct, priceOfProduct, amountOfProduct, this.action);
    }

}

