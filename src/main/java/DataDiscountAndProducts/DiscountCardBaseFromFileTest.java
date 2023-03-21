package DataDiscountAndProducts;

import discount.Discount;
import discount.DiscountCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountCardBaseFromFileTest {
    String file;
    @Test
    void TestCreatingDiscountCardBaseFromUnrealFile() {

        Discount discount1 = new DiscountCard();

        DiscountCardBaseFromFile discountCardBaseFromFile = new DiscountCardBaseFromFile();

        assertEquals(discount1.getClass(),discountCardBaseFromFile.creatingDiscountCardBaseFromFile(file).getClass());
    }
}