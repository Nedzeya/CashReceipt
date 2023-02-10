public class ProductFactory {
    Product createSimpleProduct(int IdOfProduct, String nameOfProduct, double priceOfProduct, int amountOfProduct) {
        return new SimpleProduct(IdOfProduct, nameOfProduct, priceOfProduct, amountOfProduct);
    }

    Product createActionProduct(int IdOfProduct, String nameOfProduct, double priceOfProduct, int amountOfProduct, Actions action) {
        return new ActionProduct(IdOfProduct, nameOfProduct, priceOfProduct, amountOfProduct, action);
    }
}

