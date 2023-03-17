package basket;

import org.junit.jupiter.api.Test;
import product.Product;
import product.ProductFactory;
import product.SimpleProduct;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasketTest {


        @Test
    void TestTotalOfEmptyBasket() {
        Basket basket = new Basket();
        assertEquals(0, basket.totalOfBasket());
    }

    @Test
    void TestTotalOfBasketWithOneSimpleProduct() {
        Basket basket = new Basket();
        ProductFactory productFactory = new ProductFactory();
        Product product = productFactory.createSimpleProduct(1, "one", 10.5);
        product.setAmountOfProduct(1);
        basket.addProduct(product);

        assertEquals(10.5, basket.totalOfBasket());
    }

    @Test
    void TestTotalOfBasketWithTreeSimpleProducts() {
        Basket basket = new Basket();
        ProductFactory productFactory = new ProductFactory();
        Product product1 = productFactory.createSimpleProduct(1, "one", 10.5);
        product1.setAmountOfProduct(1);
        Product product2 = productFactory.createSimpleProduct(2, "two", 15);
        product2.setAmountOfProduct(2);
        Product product3 = productFactory.createSimpleProduct(3, "tree", 10.6);
        product3.setAmountOfProduct(6);

        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);

        assertEquals(104.1, basket.totalOfBasket());

    }


    @Test
    void TestTotalOfBasketWithOneActionProductAmountSix() {
        Basket basket = new Basket();
        ProductFactory productFactory = new ProductFactory();
        Product product = productFactory.createActionSixProductsProduct(1, "one", 10.5);
        product.setAmountOfProduct(6);
        basket.addProduct(product);

        assertEquals(56.7, basket.totalOfBasket());
    }

    @Test
    void TestTotalOfBasketWithTreeActionProductsDifferentAmount() {
        Basket basket = new Basket();
        ProductFactory productFactory = new ProductFactory();
        Product product1 = productFactory.createActionSixProductsProduct(1, "one", 10.5);
        product1.setAmountOfProduct(1);
        Product product2 = productFactory.createActionSixProductsProduct(2, "two", 15);
        product2.setAmountOfProduct(2);
        Product product3 = productFactory.createActionSixProductsProduct(3, "tree", 10.6);
        product3.setAmountOfProduct(6);

        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);

        assertEquals(40,5, basket.totalOfBasket());

    }

    @Test
    void TestTotalOfBasketWithTwoActionAndSimpleProducts() {
        Basket basket = new Basket();
        ProductFactory productFactory = new ProductFactory();
        Product product1 = productFactory.createActionSixProductsProduct(1, "one", 10.5);
        product1.setAmountOfProduct(8);
        Product product2 = productFactory.createSimpleProduct(2, "two", 15);
        product2.setAmountOfProduct(2);


        basket.addProduct(product1);
        basket.addProduct(product2);


        assertEquals(105.6, basket.totalOfBasket(),0.1);

    }

    @Test
    void TestAddOneProductInTheBasket() {
        Basket basket = new Basket();
        ProductFactory productFactory = new ProductFactory();
        Product product1 = productFactory.createActionSixProductsProduct(1, "one", 10.5);

        basket.addProduct(product1);

        Set<Integer> keys = basket.getBasketMap().keySet();
        int howMuchProductsInTheBasket=keys.size();

        assertEquals(1, howMuchProductsInTheBasket);
    }

    @Test
    void TestAddTreeProductsInTheBasket() {
        Basket basket = new Basket();
        ProductFactory productFactory = new ProductFactory();
        Product product1 = productFactory.createActionSixProductsProduct(1, "one", 10.5);
        Product product2 = productFactory.createSimpleProduct(2, "two", 15);
        Product product3 = productFactory.createActionSixProductsProduct(3, "tree", 10.6);

        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);

        Set<Integer> keys = basket.getBasketMap().keySet();
        int howMuchProductsInTheBasket=keys.size();

        assertEquals(3, howMuchProductsInTheBasket);
    }

    @Test
    void TestToStringEmptyBasket() {
        Basket basket = new Basket();
        StringBuilder sb = new StringBuilder(" ");
        for (Integer key : basket.getBasketMap().keySet()) {
            sb.append(basket.getBasketMap().get(key));
        }
        assertEquals( String.format("%-4S %-20S %-8S %-8S\n\n","QTY","DESCRIPTION","PRICE", "TOTAL")
                + sb +
                "\n===========================================\n\n"+
                String.format("%-30S %S %.2f","TOTAL","$",basket.totalOfBasket()),basket.toString());

    }

    @Test
    void TestToStringFullBasket() {
        Basket basket = new Basket();
        ProductFactory productFactory = new ProductFactory();
        Product product1 = productFactory.createActionSixProductsProduct(1, "one", 10.5);
        Product product2 = productFactory.createSimpleProduct(2, "two", 15);
        basket.addProduct(product1);
        basket.addProduct(product2);

        StringBuilder sb = new StringBuilder(" ");
        for (Integer key : basket.getBasketMap().keySet()) {
            sb.append(basket.getBasketMap().get(key));
        }
        assertEquals( String.format("%-4S %-20S %-8S %-8S\n\n","QTY","DESCRIPTION","PRICE", "TOTAL")
                + sb +
                "\n===========================================\n\n"+
                String.format("%-30S %S %.2f","TOTAL","$",basket.totalOfBasket()),basket.toString());

    }

    @Test
    void TesGetEmptyBasketMap() {
        Basket basket = new Basket();
        Map<Integer, Product> basketMap = new HashMap<>();
        assertEquals(basketMap, basket.getBasketMap());
    }

    @Test
    void TesGetFullBasketMap() {
        Basket basket = new Basket();
        ProductFactory productFactory = new ProductFactory();
        Product product1 = productFactory.createActionSixProductsProduct(1, "one", 10.5);
        Product product2 = productFactory.createSimpleProduct(2, "two", 15);
        basket.addProduct(product1);
        basket.addProduct(product2);

        Map<Integer, Product> basketMap = new HashMap<>();
        basketMap.put(1,product1);
        basketMap.put(2,product2);

        assertEquals(basketMap, basket.getBasketMap());
    }

}