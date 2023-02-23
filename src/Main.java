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
        args = new String[4];
args [ 0] = "3-1";
args [ 1] = "4-1";
args [ 2] = "6-5";
args [ 3] = "card-1";

        Discount discount = new DiscountCard();
        discount.addDiscount(new DiscountCard(4, 1));
        discount.addDiscount(new DiscountCard(1, 2));
        //Map<Integer, Discount> discountMap = discount.getDiscountMap();
//        for (Integer key: discountMap.keySet()) {
//            System.out.printf("%-10s\n", discountMap.get(key));
//        }

        ProductFactory productFactory = new ProductFactory();
        Product product1 = productFactory.createActionSixProduct(3, "hhh", 888, 0);
        Product product2 = productFactory.createActionSixProduct(4, "hph", 98, 0);
        Product product3 = productFactory.createSimpleProduct(5, "q", 978, 0);
        Product product4 = productFactory.createSimpleProduct(6, "w", 9, 0);
//        Map<Integer, Product> productMap = productFactory.getProductMap();
//        for (Integer key: productMap.keySet()){
//      System.out.println("the product map is");
//      System.out.printf("%-10s", productMap.get(key));
//  }



        Basket basket = new Basket();

//        Map<Integer, Product> basketMap = basket.getProductMap();  // what we have in bASKET after adding
//  for (Integer key: basketMap.keySet()){
//      System.out.println("the basket map is");
//      System.out.printf("%-10s", basketMap.get(key));
//  }





        for ( int i = 0; i < args.length; i++) {
          //  System.out.println(args[i]);






            if (args[i].toLowerCase().contains("card")){
                System.out.println("card we have " + args[i]);
              try {
                  Integer numberOfCard = Integer.valueOf(args[i].substring(5));
                  System.out.println("number of card is " + numberOfCard);
                  if (discount.getDiscountMap().containsKey(numberOfCard)){
                      basket = new DiscountCardBasket(basket, numberOfCard);
                  }
              } catch (NumberFormatException e){
                  System.out.println("incorrect number of card");
              }


            }
//            basket.addProduct(product1);
//            basket.addProduct(product2);
//            basket.addProduct(product3);
//            basket.addProduct(product4);

















        }


        Receipt receipt1 = new Receipt.ReceiptBuilder(basket)
                .setIsPrintInConsole(true)
                .setIsSaveInFile(false)
                .build();


    }
}