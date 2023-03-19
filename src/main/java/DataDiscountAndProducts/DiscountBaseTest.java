package DataDiscountAndProducts;

import discount.Discount;
import discount.DiscountCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountBaseTest {
    Discount discount1 = new DiscountCard();
    String file;

    class TestDiscountBase implements DiscountBase{

        @Override
        public Discount addingDiscountCardBaseFromFile() {

            return discount1;
        }
    }

    @Test
    void TestReadingFromFile() {
        DiscountBase discountBase = new TestDiscountBase();

        assertEquals(discount1,discountBase.addingDiscountCardBaseFromFile());
    }


}