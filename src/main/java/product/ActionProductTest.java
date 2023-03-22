package product;

import actions.ActionSixProducts;
import actions.Actions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActionProductTest {
Actions action = new ActionSixProducts();
Actions action1 = new ActionSixProducts();


    @Test
    void testGetAction() {
        ActionProduct product = new ActionProduct(1,"nameOfProduct",100,action );
        assertEquals(action, product.getAction());
    }

    @Test
    void testSetAction() {
        ActionProduct product = new ActionProduct(1,"nameOfProduct",100,action );
        product.setAction(action1);
        assertEquals(action1, product.getAction());
    }



    @Test
    void testTotalPriceOfProductAmountOutOfAction() {
        ActionProduct product = new ActionProduct(1,"nameOfProduct",100,action );
        product.setAmountOfProduct(5);

        assertEquals(500, product.totalPriceOfProduct());

    }
    @Test
    void testTotalPriceOfProductAmountUnderAction() {
        ActionProduct product = new ActionProduct(1,"nameOfProduct",100,action );
        product.setAmountOfProduct(6);

        assertEquals(540, product.totalPriceOfProduct());

    }

    @Test
    void testToStringProductAmountOutOfAction(){
        ActionProduct product = new ActionProduct(1,"nameOfProduct",100,action );
        product.setAmountOfProduct(3);
        assertEquals(String.format("%-3d %-20s $%-8.2f $%-8.2f\n ", product.getAmountOfProduct(), product.getNameOfProduct(),
                product.getPriceOfProduct(), product.totalPriceOfProduct()), product.toString());
    }

    @Test
    void testToStringProductAmountUnderAction(){
        ActionProduct product = new ActionProduct(1,"nameOfProduct",100,action );
        product.setAmountOfProduct(8);
        double totalPriceOfPrWithoutAct = product.getPriceOfProduct() * product.getAmountOfProduct();
        double sumOfAction = totalPriceOfPrWithoutAct-product.totalPriceOfProduct();

        assertEquals(String.format("%-3d %-20s $%-8.2f %-8.2f\n %35s%.2f\n %35s%.2f\n ", product.getAmountOfProduct(), product.getNameOfProduct(),
                product.getPriceOfProduct(), totalPriceOfPrWithoutAct,"-",sumOfAction,"$",product.totalPriceOfProduct()), product.toString());
    }
}