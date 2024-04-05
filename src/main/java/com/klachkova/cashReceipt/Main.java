package com.klachkova.cashReceipt;

import com.klachkova.cashReceipt.data.dataDiscount.CreatingDiscountCardBaseFromFile;
import com.klachkova.cashReceipt.data.dataDiscount.DiscountBase;
import com.klachkova.cashReceipt.data.dataProducts.CreatingProductBaseFromFile;
import com.klachkova.cashReceipt.data.dataProducts.ProductBase;
import basket.Basket;
import com.klachkova.cashReceipt.discount.Discount;
import com.klachkova.cashReceipt.mainUtil.BasketArgsRecognition;
import com.klachkova.cashReceipt.mainUtil.FileNamesFromArg;
import com.klachkova.cashReceipt.product.ProductFactory;
import com.klachkova.cashReceipt.receipt.Receipt;


public class Main {


    public static void main(String[] args) {

        String nameOfDiscountCardFile = "";
        String nameOfProductsBase = "";

        ProductFactory productFactory;
        Basket basket;
        Discount discount;

        if (args.length > 0) {
            FileNamesFromArg namesFromArg = new FileNamesFromArg(args);
            namesFromArg.takeNamesFromArgs();
            args = namesFromArg.getArgs();
            nameOfDiscountCardFile = namesFromArg.getNameOfDiscountCardFile();
            nameOfProductsBase = namesFromArg.getNameOfProductsBase();
        }


        DiscountBase discountBase = new CreatingDiscountCardBaseFromFile();
        ProductBase productBase = new CreatingProductBaseFromFile();

        discount = discountBase.creatingDiscountCardBaseFromFile(nameOfDiscountCardFile);
        productFactory = productBase.creatingProductBaseFromFile(nameOfProductsBase);


        BasketArgsRecognition argsRecognition = new BasketArgsRecognition(args);
        basket = argsRecognition.creationOfBasket(discount, productFactory);


        Receipt receipt1 = new Receipt.ReceiptBuilder(basket)
                .setIsPrintInConsole(true)
                .setIsSaveInFile(false)
                .build();


    }

}