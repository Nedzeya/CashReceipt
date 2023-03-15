package product;

import java.util.Objects;

public abstract class Product {
    //standard for all main.java.product
    private int idOfProduct;
    private String nameOfProduct;
    private double priceOfProduct;
    private int amountOfProduct=0;




    // basic constructor
    public Product(int idOfProduct, String nameOfProduct, double priceOfProduct) {
        this.idOfProduct = idOfProduct;
        this.nameOfProduct = nameOfProduct;
        this.priceOfProduct = priceOfProduct;

    }

// getters

    public int getIdOfProduct() {
        return idOfProduct;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public double getPriceOfProduct() {
        return priceOfProduct;
    }

    public void setAmountOfProduct(int amountOfProduct) {
        this.amountOfProduct = amountOfProduct;
    }

    public int getAmountOfProduct() {
        return amountOfProduct;
    }

    //functions for all main.java.product types


    public boolean isEmpty() {
        return nameOfProduct.isBlank() || amountOfProduct == 0;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Product product = (Product) object;
        return this.getIdOfProduct() == product.getIdOfProduct()
                && Double.compare(product.getPriceOfProduct(), this.getPriceOfProduct()) == 0
                && Objects.equals(this.getNameOfProduct().toUpperCase(), product.getNameOfProduct().toUpperCase());
    }

    @Override
    public int hashCode() {
        return 31 * Objects.hash(idOfProduct, nameOfProduct, priceOfProduct, amountOfProduct);
    }

    // functions for all main.java.product which need to be overridden
    public abstract String toString();

    public abstract double totalPriceOfProduct();


}

