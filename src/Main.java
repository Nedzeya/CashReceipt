import basket.Basket;
import discount.Discount;
import discount.DiscountCard;
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
        Product product2 = productFactory.createActionSixProduct(585, "hhh", 98, 7);
        Product product3 = productFactory.createSimpleProduct(5, "q", 978, 1);
        Product product4 = productFactory.createSimpleProduct(6, "w", 9, 1);


        //Basket basket = new DiscountCardBasket(new Basket(), 1);
        Basket basket = new Basket();
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);


        Receipt receipt1 = new Receipt.ReceiptBuilder(basket)
                .setIsPrintInConsole(true)
                .setIsSaveInFile(true)
                .build();




    }
}