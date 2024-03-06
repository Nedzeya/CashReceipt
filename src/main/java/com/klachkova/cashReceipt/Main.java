package com.klachkova.cashReceipt;

import com.klachkova.cashReceipt.data.dataDiscount.CreatingDiscountCardBaseFromFile;
import com.klachkova.cashReceipt.data.dataDiscount.DiscountBase;
import com.klachkova.cashReceipt.data.dataProducts.CreatingProductBaseFromFile;
import com.klachkova.cashReceipt.data.dataProducts.ProductBase;
import basket.Basket;
import basket.DiscountCardBasket;
import com.klachkova.cashReceipt.discount.Discount;
import com.klachkova.cashReceipt.mainUtil.NamesFromArg;
import com.klachkova.cashReceipt.product.Product;
import com.klachkova.cashReceipt.product.ProductFactory;
import com.klachkova.cashReceipt.receipt.Receipt;


public class Main {


    public static void main(String[] args) {

        String nameOfDiscountCardFile = "";
        String nameOfProductsBase = "";

        ProductFactory productFactory;
        Basket basket = new Basket();
        Discount discount;

        if (args.length > 0) {
            NamesFromArg namesFromArg = new NamesFromArg(args);
            namesFromArg.takeNamesFromArgs();
            args = namesFromArg.getArgs();
            nameOfDiscountCardFile = namesFromArg.getNameOfDiscountCardFile();
            nameOfProductsBase = namesFromArg.getNameOfProductsBase();
        }


        DiscountBase discountBase = new CreatingDiscountCardBaseFromFile();
        ProductBase productBase = new CreatingProductBaseFromFile();

        discount = discountBase.creatingDiscountCardBaseFromFile(nameOfDiscountCardFile);
        productFactory = productBase.creatingProductBaseFromFile(nameOfProductsBase);

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

        Receipt receipt1 = new Receipt.ReceiptBuilder(basket)
                .setIsPrintInConsole(true)
                .setIsSaveInFile(false)
                .build();


    }

    static void productRecognition(ProductFactory productFactory, Basket basket, Integer idOfProduct, Integer amountOfProduct) {
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

    static Basket cardRecognition(Basket basket, Discount discount, Integer numberOfCard) {
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