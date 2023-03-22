package product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleProductTest {




    @Test
    void testTotalPriceOfProduct() {
        Product product1 = new SimpleProduct(1, "D", 2);
        product1.setAmountOfProduct(13);
        assertEquals(26,product1.totalPriceOfProduct() , .01);
    }

    @Test
    void testTotalPriceOfProductWithNegativePrice() {
        Product product1 = new SimpleProduct(1, "D", -202);
        product1.setAmountOfProduct(13);
        assertEquals(2626,product1.totalPriceOfProduct() , .01);
    }

    @Test
    void testTotalPriceOfProductWithNegativeAmount() {
        Product product1 = new SimpleProduct(1, "D", 202);
        product1.setAmountOfProduct(-13);
        assertEquals(2626,product1.totalPriceOfProduct() , .01);
    }
    @Test
    void testToString() {
        Product product1 = new SimpleProduct(1, "D", 2);
        product1.setAmountOfProduct(41);
        assertEquals(String.format("%-3d %-20s $%-8.2f $%-8.2f\n ", product1.getAmountOfProduct(), product1.getNameOfProduct(),
                product1.getPriceOfProduct(), product1.totalPriceOfProduct()), product1.toString());

    }
}