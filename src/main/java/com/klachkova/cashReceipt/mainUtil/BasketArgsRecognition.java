package com.klachkova.cashReceipt.mainUtil;

import basket.Basket;
import basket.DiscountCardBasket;
import com.klachkova.cashReceipt.discount.Discount;
import com.klachkova.cashReceipt.product.Product;
import com.klachkova.cashReceipt.product.ProductFactory;

public class BasketArgsRecognition {

    private String[] args;


    public BasketArgsRecognition(String[] args) {
        this.args = args;
    }

    public Basket creationOfBasket(Discount discount, ProductFactory productFactory) {

        Basket basket = new Basket();

        for (int i = 0; i < args.length; i++) {
            if (args[i] != null && !args[i].toLowerCase().contains(".txt")) {

                if (args[i].toLowerCase().contains("card-")) {

                    Integer numberOfCard = Integer.valueOf(args[i].substring(5));
                    basket = cardRecognition(basket, discount, numberOfCard);

                } else {
                    try {
                        Integer idOfProduct = Integer.valueOf(args[i].substring(0, args[i].indexOf("-")));
                        Integer amountOfProduct = Integer.valueOf(args[i].substring(args[i].indexOf("-") + 1));

                        productRecognition(productFactory, basket, idOfProduct, amountOfProduct);
                    } catch (StringIndexOutOfBoundsException e) {
                        System.out.println("incorrect data information ");
                    }
                }
            }
        }
        return basket;
    }

    private void productRecognition(ProductFactory productFactory, Basket basket, Integer idOfProduct, Integer amountOfProduct) {
        try {
            if (productFactory.getProductMap().containsKey(idOfProduct)) {
                Product product = productFactory.getProductMap().get(idOfProduct);

                if (product.getAmountOfProduct() == 0) {

                    product.setAmountOfProduct(amountOfProduct);
                } else {
                    product.setAmountOfProduct(product.getAmountOfProduct() + amountOfProduct);
                }
                basket.addProduct(product);
            } else {
                System.out.println("there are no such product ");
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            System.out.println("incorrect product");
        }
    }

    private Basket cardRecognition(Basket basket, Discount discount, Integer numberOfCard) {
        try {
            if (discount.getDiscountMap().containsKey(numberOfCard)) {
                return new DiscountCardBasket(basket.getBasketMap(), numberOfCard);
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            System.out.println("incorrect number of card");
        }
        return basket;
    }
}
