import basket.Basket;
import discount.Discount;
import discount.DiscountCard;
import product.Product;
import product.ProductFactory;
import receipt.Receipt;
import receipt.ReceiptInput;
import receipt.ReceiptInputFromConsole;
import receipt.ReceiptInputFromFile;


public class Main {
    public static void main(String[] args) {

//        args = new String[4];
//        args[0] = "3-10";
//        args[1] = "4-1";
//        args[2] = "card-5";
//        args[3] = "5-2";

        args = new String[1];
        args[0] = "receiptInput.txt";


        Discount discount = new DiscountCard();
        discount.addDiscount(new DiscountCard(4, 1));
        discount.addDiscount(new DiscountCard(1, 2));


        ProductFactory productFactory = new ProductFactory();
        Product product1 = productFactory.createActionSixProduct(3, "hhh", 888);
        Product product2 = productFactory.createActionSixProduct(4, "hph", 98);
        Product product3 = productFactory.createSimpleProduct(5, "q", 978);
        Product product4 = productFactory.createSimpleProduct(6, "w", 9);




        Basket basket = new Basket();

        ReceiptInput input;

//        input = new ReceiptInputFromConsole();
//        input.input(args,productFactory,basket,discount);

        input = new ReceiptInputFromFile();
        input.input(args,productFactory,basket,discount);


            Receipt receipt1 = new Receipt.ReceiptBuilder(basket)
                    .setIsPrintInConsole(true)
                    .setIsSaveInFile(false)
                    .build();


    }
}