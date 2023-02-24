import basket.Basket;
import basket.DiscountCardBasket;
import discount.Discount;
import discount.DiscountCard;
import product.Product;
import product.ProductFactory;
import receipt.Receipt;

import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
//        args = new String[4];
//args [ 0] = "3-10";
//args [ 1] = "4-1";
//args [ 2] = "card-5";
//args [ 3] = "5-2";

        Discount discount = new DiscountCard();
        discount.addDiscount(new DiscountCard(4, 1));
        discount.addDiscount(new DiscountCard(1, 2));
        //Map<Integer, Discount> discountMap = discount.getDiscountMap();
//        for (Integer key: discountMap.keySet()) {
//            System.out.printf("%-10s\n", discountMap.get(key));
//        }

        ProductFactory productFactory = new ProductFactory();
        Product product1 = productFactory.createActionSixProduct(3, "hhh", 888);
        Product product2 = productFactory.createActionSixProduct(4, "hph", 98);
        Product product3 = productFactory.createSimpleProduct(5, "q", 978);
        Product product4 = productFactory.createSimpleProduct(6, "w", 9);
//        Map<Integer, Product> productMap = productFactory.getProductMap();
//        for (Integer key: productMap.keySet()){
//      System.out.println("the product map is");
//      System.out.printf("%-10s", productMap.get(key));
//  }



        Basket basket = new Basket();
//        Map<Integer, Product> basketMap = basket.getBasketMap();
//        basket.addProduct(product4);
//
//        basket = new DiscountCardBasket(basket.getBasketMap(), 1);
//        basket.addProduct(product2);
//         // what we have in bASKET after adding
//  for (Integer key: basketMap.keySet()){
//      System.out.println("the basket map is");
//      System.out.printf("%-10s", basketMap.get(key));
//  }





        for ( int i = 0; i < args.length; i++) {
       //     System.out.println(args[i]);


            //  System.out.println(args[i]);
            if (args[i]!=null && !args[i].toLowerCase().contains("card")) {
                try {
                   // System.out.println("product we have " + args[i]);
                    Integer idOfProduct = Integer.valueOf(args[i].substring(0, args[i].indexOf("-")));
                   // System.out.println("id of product is " + idOfProduct);
                    Integer amountOfProduct = Integer.valueOf(args[i].substring(args[i].indexOf("-") + 1));
                   // System.out.println("amount of product is " + amountOfProduct);
                    if (productFactory.getProductMap().containsKey(idOfProduct)) {
                        Product product = productFactory.getProductMap().get(idOfProduct);
                        product.setAmountOfProduct(amountOfProduct);
                        basket.addProduct(product);
                       // System.out.println("was added product  " + product);
                    } else {
                        System.out.println("there are no such product "+ args [i]);
                    }
                }catch (NumberFormatException e){
                    System.out.println("incorrect  product");
                }



            }

            else {
                //System.out.println("card we have " + args[i]);
                try {
                    Integer numberOfCard = Integer.valueOf(args[i].substring(5));
                    //System.out.println("number of card is " + numberOfCard);
                    if (discount.getDiscountMap().containsKey(numberOfCard)) {
                        basket = new DiscountCardBasket(basket.getBasketMap(), numberOfCard);

                    }
                } catch (NumberFormatException e) {
                    System.out.println("incorrect number of card");
                }

            }
        }

            Receipt receipt1 = new Receipt.ReceiptBuilder(basket)
                    .setIsPrintInConsole(true)
                    .setIsSaveInFile(true)
                    .build();


    }
}