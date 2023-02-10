public class SimpleProduct extends Product {


    public SimpleProduct(int idOfProduct, String nameOfProduct, double priceOfProduct, int amountOfProduct) {
        super(idOfProduct, nameOfProduct, priceOfProduct, amountOfProduct);
    }

    @Override
    public double totalPriceOfProduct() {
        return priceOfProduct * amountOfProduct;
    }

    @Override
    public String toString() {
        return amountOfProduct  + " " + nameOfProduct + " $" + priceOfProduct +
                " $" + totalPriceOfProduct();
    }
}
