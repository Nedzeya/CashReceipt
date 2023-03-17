package basket;

import discount.Discount;
import discount.DiscountCard;
import org.junit.jupiter.api.Test;
import product.Product;
import product.ProductFactory;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiscountCardBasketTest {

    @Test
    void TestTotalOfEmptyDiscountCardBasket() {
        Basket basket = new Basket();
        Map<Integer, Product> basketMap = basket.getBasketMap();

        Discount discount = new DiscountCard();
        discount.addDiscount(new DiscountCard(10, 1));

        basket = new DiscountCardBasket(basketMap, 1);

        assertEquals(0, basket.totalOfBasket());
    }

    @Test
    void TestTotalOfFullDiscountCardBasket() {
        Basket basket = new Basket();
        Map<Integer, Product> basketMap = basket.getBasketMap();

        Discount discount = new DiscountCard();
        discount.addDiscount(new DiscountCard(10, 1));

        ProductFactory productFactory = new ProductFactory();
        Product product1 = productFactory.createActionSixProductsProduct(1, "one", 10.5);
        product1.setAmountOfProduct(1);
        Product product2 = productFactory.createSimpleProduct(2, "two", 15);
        product2.setAmountOfProduct(1);

        basket.addProduct(product1);
        basket.addProduct(product2);

        basket = new DiscountCardBasket(basketMap, 1);



        assertEquals(22.95, basket.totalOfBasket());
    }

    @Test
    void testToStringOfEmptyDiscountCardBasket() {
        Basket basket = new Basket();
        Map<Integer, Product> basketMap = basket.getBasketMap();
        double superTotal = basket.totalOfBasket();

        Discount discount = new DiscountCard();
        discount.addDiscount(new DiscountCard(10, 1));

        basket = new DiscountCardBasket(basketMap, 1);


        StringBuilder sb = new StringBuilder(" ");
        for (Integer key : basket.getBasketMap().keySet()) {
            sb.append(basket.getBasketMap().get(key));
        }

        assertEquals(String.format("%-4S %-20S %-8S %-8S\n\n","QTY","DESCRIPTION","PRICE", "TOTAL")
                + sb +
                "\n===========================================\n\n"+
                String.format("%-30S  %.2f\n %30s %.2f\n %30S %.2f",
                        "TOTAL",superTotal,"-",superTotal-basket.totalOfBasket(),"$",basket.totalOfBasket()),


                basket.toString());

    }

    @Test
    void testToStringOfFullDiscountCardBasket() {
        Basket basket = new Basket();
        Map<Integer, Product> basketMap = basket.getBasketMap();
        ProductFactory productFactory = new ProductFactory();
        Product product1 = productFactory.createActionSixProductsProduct(1, "one", 10.5);
        product1.setAmountOfProduct(1);
        Product product2 = productFactory.createSimpleProduct(2, "two", 15);
        product2.setAmountOfProduct(1);

        basket.addProduct(product1);
        basket.addProduct(product2);

        double superTotal = basket.totalOfBasket();


        Discount discount = new DiscountCard();
        discount.addDiscount(new DiscountCard(10, 1));

        basket = new DiscountCardBasket(basketMap, 1);


        StringBuilder sb = new StringBuilder(" ");
        for (Integer key : basket.getBasketMap().keySet()) {
            sb.append(basket.getBasketMap().get(key));
        }

        assertEquals(String.format("%-4S %-20S %-8S %-8S\n\n","QTY","DESCRIPTION","PRICE", "TOTAL")
                        + sb +
                        "\n===========================================\n\n"+
                        String.format("%-30S  %.2f\n %30s %.2f\n %30S %.2f",
                                "TOTAL",superTotal,"-",superTotal-basket.totalOfBasket(),"$",basket.totalOfBasket()),


                basket.toString());

    }

    @Test
    void TestGetPercentsOfDiscount() {
        Basket basket = new Basket();
        Map<Integer, Product> basketMap = basket.getBasketMap();

        Discount discount = new DiscountCard();
        discount.addDiscount(new DiscountCard(10, 1));

        DiscountCardBasket discountCardBasket = new DiscountCardBasket(basketMap,1);



        assertEquals(10,discountCardBasket.getPercentsOfDiscount());
    }

    @Test
    void TestGetNumberOfDiscount() {
        Basket basket = new Basket();
        Map<Integer, Product> basketMap = basket.getBasketMap();

        Discount discount = new DiscountCard();
        discount.addDiscount(new DiscountCard(10, 1));

        DiscountCardBasket discountCardBasket = new DiscountCardBasket(basketMap,1);



        assertEquals(1,discountCardBasket.getNumberOfDiscount());
    }

    @Test
    void TestGetNameOfDiscount() {
        Basket basket = new Basket();
        Map<Integer, Product> basketMap = basket.getBasketMap();

        Discount discount = new DiscountCard();
        discount.addDiscount(new DiscountCard(10, 1));

        DiscountCardBasket discountCardBasket = new DiscountCardBasket(basketMap,1);



        assertEquals("DiscountCardOfClient",discountCardBasket.getNameOfDiscount());
    }

    @Test
    void TestGetEmptyDiscountCardBasketMap() {
        Basket basket = new Basket();
        Map<Integer, Product> basketMap = basket.getBasketMap();

        Discount discount = new DiscountCard();
        discount.addDiscount(new DiscountCard(10, 1));

        DiscountCardBasket discountCardBasket = new DiscountCardBasket(basketMap,1);

        assertEquals(basketMap, discountCardBasket.getBasketMap());

    }

    @Test
    void TestGetFullDiscountCardBasketMap() {
        Basket basket = new Basket();
        Map<Integer, Product> basketMap = basket.getBasketMap();

        ProductFactory productFactory = new ProductFactory();
        Product product1 = productFactory.createActionSixProductsProduct(1, "one", 10.5);

        Product product2 = productFactory.createSimpleProduct(2, "two", 15);
        

        basket.addProduct(product1);
        basket.addProduct(product2);

        Discount discount = new DiscountCard();
        discount.addDiscount(new DiscountCard(10, 1));

        DiscountCardBasket discountCardBasket = new DiscountCardBasket(basketMap,1);

        assertEquals(basketMap, discountCardBasket.getBasketMap());

    }
}