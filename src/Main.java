import basket.Basket;
import basket.DiscountCardBasket;
import discount.Discount;
import discount.DiscountCard;
import product.ProductFactory;


public class Main {
    public static void main(String[] args) {

        Discount discount = new DiscountCard();
        discount.addDiscount(new DiscountCard(4, 1));
        discount.addDiscount(new DiscountCard(1, 2));


        ProductFactory productFactory = new ProductFactory();
        //basket.Basket basket = new basket.Basket ();
        Basket basket = new DiscountCardBasket(new Basket(), 1);


        basket.addProduct(productFactory.createActionSixProduct(555, "hhh", 888, 1));

        basket.addProduct(productFactory.createActionSixProduct(173, "ffeeef", 2, 21));



        System.out.println(basket);


    }
}