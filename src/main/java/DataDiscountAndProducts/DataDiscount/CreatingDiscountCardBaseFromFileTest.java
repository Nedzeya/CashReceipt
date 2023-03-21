package DataDiscountAndProducts.DataDiscount;

import discount.Discount;
import discount.DiscountCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreatingDiscountCardBaseFromFileTest {
    String file;
    @Test
    void TestCreatingDiscountCardBaseFromUnrealFile() {

        Discount discount1 = new DiscountCard();

        CreatingDiscountCardBaseFromFile discountCardBaseFromFile = new CreatingDiscountCardBaseFromFile();

        assertEquals(discount1.getClass(),discountCardBaseFromFile.creatingDiscountCardBaseFromFile(file).getClass());
    }
}