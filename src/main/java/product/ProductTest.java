package product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    class TestProduct extends Product {


        public TestProduct(int idOfProduct, String nameOfProduct, double priceOfProduct) {
            super(idOfProduct, nameOfProduct, priceOfProduct);
        }

        @Override
        public String toString() {
            return "product";
        }

        @Override
        public double totalPriceOfProduct() {
            return 200;
        }
    }

    Product product = new TestProduct(1,"name",100);
    @Test
    void testGetIdOfProduct() {
        assertEquals(1,product.getIdOfProduct());
    }

    @Test
    void testGetNameOfProduct() {
        assertEquals("name",product.getNameOfProduct());
    }

    @Test
    void testGetPriceOfProduct() {
        assertEquals(100,product.getPriceOfProduct());
    }

    @Test
    void testSetPositiveAmountOfProduct() {
        product.setAmountOfProduct(20);
        assertEquals(20,product.getAmountOfProduct());
    }

    @Test
    void testSetNegativeAmountOfProduct() {
        product.setAmountOfProduct(-20);
        assertEquals(20,product.getAmountOfProduct());
    }
    @Test
    void testGetStandardAmountOfProduct() {
        assertEquals(0,product.getAmountOfProduct());
    }


    @Test
    void testEqualsIfItIsTrue() {
        Product product1 = new TestProduct(1,"name",100);
        assertEquals(true,product.equals(product1));
    }

    @Test
    void testEqualsIfItIsFalse() {
        Product product1 = new TestProduct(3,"name",100);
        assertEquals(false,product.equals(product1));
    }


    @Test
    void testHashCodeOfTheEqualsProducts() {
        Product product1 = new TestProduct(1,"name",100);
        assertEquals(product1.hashCode(),product.hashCode());
    }

    @Test
    void testHashCodeOfTheDifferentProducts() {
        Product product1 = new TestProduct(10,"name",100);
        assertEquals(false,product1.hashCode()== product.hashCode());
    }

    @Test
    void testToString() {
        assertEquals("product",product.toString());
    }

    @Test
    void totalPriceOfProduct() {
        assertEquals(200,product.totalPriceOfProduct());
    }
}