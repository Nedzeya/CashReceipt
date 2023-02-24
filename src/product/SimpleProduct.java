package product;

import product.Product;

public class SimpleProduct extends Product {


    public SimpleProduct(int idOfProduct, String nameOfProduct, double priceOfProduct) {
        super(idOfProduct, nameOfProduct, priceOfProduct);
    }

    @Override
    public double totalPriceOfProduct() {

        return getPriceOfProduct() * getAmountOfProduct();
    }

    @Override
    public String toString() {
        return String.format("%-3d %-20s $%-8.2f $%-8.2f\n ", getAmountOfProduct(), getNameOfProduct(),
                getPriceOfProduct(), totalPriceOfProduct());
    }

}
