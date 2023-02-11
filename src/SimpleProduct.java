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
        return String.format("%-3x %-20s $%-8.2f $%-8.2f\n ", amountOfProduct, nameOfProduct,
                priceOfProduct, totalPriceOfProduct());
    }
}
