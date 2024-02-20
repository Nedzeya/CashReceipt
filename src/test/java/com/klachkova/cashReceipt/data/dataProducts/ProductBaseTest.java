package com.klachkova.cashReceipt.data.dataProducts;

import org.junit.jupiter.api.Test;
import com.klachkova.cashReceipt.product.ProductFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductBaseTest {
ProductFactory productFactory = new ProductFactory();
    String file;

    class TestProductBase implements ProductBase {


        @Override
        public ProductFactory creatingProductBaseFromFile(String nameOfFile) {
            return productFactory;
        }
    }
    @Test
    void testCreatingProductBaseFromFile() {
        ProductBase productBase = new TestProductBase();
        assertEquals(productFactory,productBase.creatingProductBaseFromFile(file));
    }
}