package com.klachkova.cashReceipt.data.dataProducts;

import com.klachkova.cashReceipt.readerFromFile.ReaderFromFileIntoStringArray;
import com.klachkova.cashReceipt.readerFromFile.ReaderFromFileIntoStringArraySplitEnter;
import com.klachkova.cashReceipt.product.ProductFactory;

public class CreatingProductBaseFromFile implements ProductBase {

    private String[] args;
    private ProductFactory productFactory = new ProductFactory();

    public CreatingProductBaseFromFile() {

    }

    private void readingProductBaseFromFile(String nameOfFile) {
        ReaderFromFileIntoStringArray readerFromFile = new ReaderFromFileIntoStringArraySplitEnter();
        this.args = readerFromFile.readFromFile(nameOfFile);
    }

FindingDataOfProductBaseInArray findingDataOfProductBaseInArray = new FindingDataOfProductBaseInArray();
    @Override
    public ProductFactory creatingProductBaseFromFile(String nameOfFile) {


     readingProductBaseFromFile(nameOfFile);

     Integer[] idsOfProducts = findingDataOfProductBaseInArray.idsOfProduct(args);
     String[] namesOfProducts = findingDataOfProductBaseInArray.namesOfProduct(args);
     Double[] pricesOfProducts = findingDataOfProductBaseInArray.pricesOfProduct(args);
     String[] actions = findingDataOfProductBaseInArray.gettingOfAction(args);

     ProductFactory productFactory = new ProductFactory();
        if (nameOfFile != null && !nameOfFile.isEmpty() && actions !=null){
     for (int i = 0; i < args.length; i++) {

         if (actions[i].toLowerCase().contains("sixproducts")) {
             //System.out.println("creating action pr");
             productFactory.createActionSixProductsProduct(idsOfProducts[i], namesOfProducts[i], pricesOfProducts[i]);
         } else {
             //System.out.println("creating simple pr");

             if (!actions[i].trim().equals("")) {

                 //  System.out.println("Action \"" + action.trim()+ "\" not found. Creating of simple main.java.com.klachkova.cashReceipt.actions.product");
             }
             productFactory.createSimpleProduct(idsOfProducts[i], namesOfProducts[i], pricesOfProducts[i]);
         }
         }

     }
 else {
             System.out.println(" com.klachkova.cashReceipt.actions.product factory base without data was created");

         }
       return productFactory;

    }
}
