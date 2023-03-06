package tests;

//import org.junit.Test;
import product.Product;
import product.SimpleProduct;

//import static org.junit.Assert.*;

public class SimpleProductTest {

    Product product1 = new SimpleProduct(1, "D", 2);
    Product product2 = new SimpleProduct(2, "E", 3.2);
    Product product3 = new SimpleProduct(2, "E", 3.2);

//    @Test
//    public void totalPriceOfProduct1() {
//        assertEquals(product1.totalPriceOfProduct(), 6, .01);
//    }
//
//    @Test
//    public void totalPriceOfProduct2() {
//        assertEquals(product2.totalPriceOfProduct(), 12.8, 0.01);
//    }
//
//    @Test
//    public void equalsPr2Pr3() {
//        assertEquals(product2, product3);
//    }


}