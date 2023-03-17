package actions;

import static org.junit.jupiter.api.Assertions.*;

class ActionSixProductsTest {

    Actions action = new ActionSixProducts();

    @org.junit.jupiter.api.Test
    void testGetNameOfActionSixProducts() {

        assertEquals("Six products",action.getNameOfAction());
    }

    @org.junit.jupiter.api.Test
    void testGetPercentsOfActionSixProducts() {
        assertEquals(0.1,action.getPercents());
    }

    @org.junit.jupiter.api.Test
    void TestGetCountOfProductOfActionSixProducts() {
        assertEquals(6,action.getCountOfProduct());
    }
}