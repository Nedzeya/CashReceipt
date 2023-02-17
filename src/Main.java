import basket.Basket;
import basket.DiscountCardBasket;
import discount.Discount;
import discount.DiscountCard;
import heardOfReceipt.HeardOfReceipt;
import product.Product;
import product.ProductFactory;
import receipt.Receipt;


public class Main {
    public static void main(String[] args) {

        Discount discount = new DiscountCard();
        discount.addDiscount(new DiscountCard(4, 1));
        discount.addDiscount(new DiscountCard(1, 2));


        ProductFactory productFactory = new ProductFactory();
        Product product1 = productFactory.createActionSixProduct(555, "hhh", 888, 1);

        // Basket basket = new DiscountCardBasket(new Basket(), 1);
        //  Basket basket = new Basket();

//        basket.addProduct(productFactory.createActionSixProduct(555, "hhh", 888, 1));
//        basket.addProduct(productFactory.createActionSixProduct(173, "ffeeef", 2, 21));


        Receipt receipt = new Receipt.ReceiptBuilder(new Basket(product1))
               // .setDiscountCardSubmitted(false)
                .build();


        System.out.println(receipt);



    }
}