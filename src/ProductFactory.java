public class ProductFactory {

    Actions action = new ActionSixProducts();
    Product createSimpleProduct(int IdOfProduct, String nameOfProduct, double priceOfProduct, int amountOfProduct) {
        return new SimpleProduct(IdOfProduct, nameOfProduct, priceOfProduct, amountOfProduct);
    }

    Product createActionSixProduct(int IdOfProduct, String nameOfProduct, double priceOfProduct, int amountOfProduct) {
        return new ActionProduct(IdOfProduct, nameOfProduct, priceOfProduct, amountOfProduct, this.action);
    }

}

