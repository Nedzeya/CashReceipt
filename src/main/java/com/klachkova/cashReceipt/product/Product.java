package com.klachkova.cashReceipt.product;

import java.util.Objects;

public abstract class Product {
    //standard for all com.klachkova.cashReceipt.actions.product
    private int idOfProduct;
    private String nameOfProduct;
    private double priceOfProduct;
    private int amountOfProduct=0;




    // basic constructor
    public Product(int idOfProduct, String nameOfProduct, double priceOfProduct) {
        this.idOfProduct = idOfProduct;
        this.nameOfProduct = nameOfProduct;
        if (priceOfProduct >= 0) {
            this.priceOfProduct = priceOfProduct;
        } else {
            System.out.println("A negative price: " + priceOfProduct+ " has been entered. The price of an com.klachkova.cashReceipt.actions.product can only be positive. " +
                    "It will be converted into a positive number. ");
            this.priceOfProduct = priceOfProduct*-1;
        }
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
        if (amountOfProduct >= 0) {
            this.amountOfProduct = amountOfProduct;
        }else{
            System.out.println("A negative amount: " + amountOfProduct+ " has been entered. " +
                    "The amount of an com.klachkova.cashReceipt.actions.product can only be positive. " +
                    "It will be converted into a positive number. ");
            this.amountOfProduct = amountOfProduct*-1;
        }
    }

    public int getAmountOfProduct() {
        return amountOfProduct;
    }

    //functions for all com.klachkova.cashReceipt.actions.product types





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

    // functions for all main.java.com.klachkova.cashReceipt.actions.product which need to be overridden
    public abstract String toString();

    public abstract double totalPriceOfProduct();


}

