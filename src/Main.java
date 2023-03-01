import basket.Basket;
import discount.Discount;
import discount.DiscountCard;
import product.Product;
import product.ProductFactory;
import receipt.Receipt;
import receipt.ReceiptInput;
import receipt.ReceiptInputFromConsole;
import receipt.ReceiptInputFromFile;

import java.nio.file.Path;
import java.nio.file.Paths;


public class Main {
    public static void main(String[] args) {

        args = new String[4];
        args[0] = "3-1";
        args[1] = "5-1";
        args[2] = "4-1";
        args[3] = "card-5";

//        args = new String[1];
//        args[0] = "x.txt";


        Discount discount = new DiscountCard();
        discount.addDiscount(new DiscountCard(80, 5));
        discount.addDiscount(new DiscountCard(5, 1));


        ProductFactory productFactory = new ProductFactory();
        Product product1 = productFactory.createActionSixProduct(3, "hhh", 888);
        Product product2 = productFactory.createActionSixProduct(4, "hph", 98);
        Product product3 = productFactory.createSimpleProduct(5, "q", 978);
        Product product4 = productFactory.createSimpleProduct(6, "w", 9);


        Basket basket;


        ReceiptInput input;
            if (args.length>0 && args[0].toLowerCase().contains(".txt")) {
                input = new ReceiptInputFromFile();
                input.input(args, productFactory, discount);
            }
             else {
                input = new ReceiptInputFromConsole();
                input.input(args, productFactory,  discount);

            }

        Receipt receipt1 = new Receipt.ReceiptBuilder()
                .setIsPrintInConsole(true)
                .setIsSaveInFile(false)
                .build();


    }
}