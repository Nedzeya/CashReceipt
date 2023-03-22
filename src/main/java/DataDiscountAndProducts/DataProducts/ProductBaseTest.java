package DataDiscountAndProducts.DataProducts;

import DataDiscountAndProducts.DataDiscount.DiscountBase;
import discount.Discount;
import org.junit.jupiter.api.Test;
import product.ProductFactory;

import static org.junit.jupiter.api.Assertions.*;

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