package product;

import actions.ActionSixProducts;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProductFactoryTest {
    ProductFactory productFactory = new ProductFactory();

    @Test
    void testCreateSimpleProduct() {
        Product product = new SimpleProduct(1,"name",100);
        assertEquals(product,productFactory.createSimpleProduct(1,"name",100));
    }

    @Test
    void testCreateActionSixProductsProduct() {
        Product product = new ActionProduct(1,"name",100,new ActionSixProducts());
        assertEquals(product,productFactory.createActionSixProductsProduct(1,"name",100));
    }

    @Test
    void getProductMap() {

        Product product = new ActionProduct(1,"name1",100,new ActionSixProducts());
        Product product1 = new SimpleProduct(2,"name2",100);

        Map<Integer, Product> productMap = new HashMap<>();

        productFactory.createActionSixProductsProduct(1,"name1",100);
        productFactory.createSimpleProduct(2,"name2",100);

        assertEquals(true,productFactory.getProductMap().containsValue(product));
        assertEquals(true,productFactory.getProductMap().containsValue(product1));
        assertEquals(productMap.getClass(),productFactory.getProductMap().getClass());

    }
}