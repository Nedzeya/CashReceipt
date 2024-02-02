package com.klachkova.cashReceipt;

import com.klachkova.cashReceipt.data.dataDiscount.CreatingDiscountCardBaseFromFile;
import com.klachkova.cashReceipt.data.dataDiscount.DiscountBase;
import com.klachkova.cashReceipt.data.dataProducts.CreatingProductBaseFromFile;
import com.klachkova.cashReceipt.data.dataProducts.ProductBase;
import basket.Basket;
import basket.DiscountCardBasket;
import com.klachkova.cashReceipt.discount.Discount;
import com.klachkova.cashReceipt.product.Product;
import com.klachkova.cashReceipt.product.ProductFactory;
import com.klachkova.cashReceipt.receipt.input.ReceiptInput;
import com.klachkova.cashReceipt.receipt.input.ReceiptInputFromFile;
import com.klachkova.cashReceipt.receipt.Receipt;


public class Main {


    public static void main(String[] args) {

//        args = new String[6];
//        args[0] = "products.txt";
//        args[1] = "2-1";
//        args[2] = "3-1";
//        args[3] = "card-2";
//       //  args[4] = "discountCards.txt";
//       // args[4] = "qqq";
//        args[4] = " ";
//        args[5] = "1-100";

//
      /*  args = new String[3];
        args[0] = "receiptInput.txt";
        args[1] = "discountCards.txt";
        args[2] = "products.txt";
*/

        String nameOfFileReceiptInput = "";
        String nameOfDiscountCardFile = "";
        String nameOfProductsBase = "";

        ProductFactory productFactory;

        Basket basket = new Basket();

         ReceiptInput input;



        Discount discount;


        int receiptInput = 0;


        if (args.length > 0) {
            for (String s : args) {
                if (s.toLowerCase().contains("receiptinput")) {
                    receiptInput = 1;
                    nameOfFileReceiptInput = s;
                }

                if (s.toLowerCase().contains("discountcards")) {

                    nameOfDiscountCardFile = s;
                }

                if (s.toLowerCase().contains("products")) {
                    nameOfProductsBase= s;
                }

            }
            //System.out.println("receiptInput - " + receiptInput + "\n dataFromFile - " + dataFromFile);

            if (receiptInput == 1) {

                input = new ReceiptInputFromFile();
                args = input.input(nameOfFileReceiptInput);

            }



        }
        DiscountBase discountBase =  new CreatingDiscountCardBaseFromFile();
        ProductBase productBase =  new CreatingProductBaseFromFile();

        discount = discountBase.creatingDiscountCardBaseFromFile(nameOfDiscountCardFile);
        productFactory = productBase.creatingProductBaseFromFile(nameOfProductsBase);

        for (int i = 0; i < args.length; i++) {
            if (args[i] != null && !args[i].toLowerCase().contains(".txt")) {

                if (args[i].toLowerCase().contains("card-")) {

                    Integer numberOfCard = Integer.valueOf(args[i].substring(5));
                    //System.out.println("card we have " + args[i]);
                    basket = cardRecognition(basket, discount, numberOfCard);

                } else {
                    System.out.println("arg we are looking now " + args[i]);
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

    static void productRecognition (ProductFactory productFactory,Basket basket,Integer idOfProduct, Integer amountOfProduct ){


        try {
            // System.out.println("main.java.com.klachkova.cashReceipt.actions.product we have " + args[i]);

            // System.out.println("id of main.java.com.klachkova.cashReceipt.actions.product is " + idOfProduct);

            // System.out.println("amount of main.java.com.klachkova.cashReceipt.actions.product is " + amountOfProduct);
            if (productFactory.getProductMap().containsKey(idOfProduct)) {
                Product product = productFactory.getProductMap().get(idOfProduct);
                //  System.out.println("main.java.com.klachkova.cashReceipt.actions.product start amount in map " + main.java.com.klachkova.cashReceipt.actions.product.getAmountOfProduct());
                if (product.getAmountOfProduct() == 0) {

                    product.setAmountOfProduct(amountOfProduct);
                } else {
                    product.setAmountOfProduct(product.getAmountOfProduct() + amountOfProduct);
                }
                //   System.out.println("pr new amount in map " + com.klachkova.cashReceipt.actions.product.getAmountOfProduct());

                basket.addProduct(product);
                // System.out.println("was added com.klachkova.cashReceipt.actions.product  " + com.klachkova.cashReceipt.actions.product);
            } else {
                System.out.println("there are no such com.klachkova.cashReceipt.actions.product ");
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            System.out.println("incorrect com.klachkova.cashReceipt.actions.product");
        }
    }

    static Basket cardRecognition (Basket basket,Discount discount, Integer numberOfCard){
        try {

            //System.out.println("number of card is " + numberOfCard);
            if (discount.getDiscountMap().containsKey(numberOfCard)) {
                return new DiscountCardBasket(basket.getBasketMap(), numberOfCard);

            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            System.out.println("incorrect number of card");
        }
        return basket;
    }
}