package DataDiscountAndProducts.DataProducts;

import org.junit.jupiter.api.Test;
import product.ProductFactory;

import static org.junit.jupiter.api.Assertions.*;

class CreatingProductBaseFromFileTest {

    @Test
    void testCreatingProductBaseFromNullFile() {
        String file = null;
        CreatingProductBaseFromFile creatingProductBaseFromFile = new CreatingProductBaseFromFile();
        ProductFactory productFactory = new ProductFactory();
        assertEquals(productFactory.getClass(),creatingProductBaseFromFile.creatingProductBaseFromFile(file).getClass());
    }

    @Test
    void testCreatingProductBaseFromEmptyFile() {
        String file = "";
        CreatingProductBaseFromFile creatingProductBaseFromFile = new CreatingProductBaseFromFile();
        ProductFactory productFactory = new ProductFactory();
        assertEquals(productFactory.getClass(),creatingProductBaseFromFile.creatingProductBaseFromFile(file).getClass());
    }
    @Test
    void testCreatingProductBaseFromUnrealFile() {
        String file = "UnrealFile";
        CreatingProductBaseFromFile creatingProductBaseFromFile = new CreatingProductBaseFromFile();
        ProductFactory productFactory = new ProductFactory();
        assertEquals(productFactory.getClass(),creatingProductBaseFromFile.creatingProductBaseFromFile(file).getClass());
    }


}