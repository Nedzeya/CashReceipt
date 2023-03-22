package DataDiscountAndProducts.DataDiscount;

import discount.Discount;
import discount.DiscountCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreatingDiscountCardBaseFromFileTest {
    String file;
    @Test
    void TestCreatingDiscountCardBaseFromNullFile() {
        String file = null;

        Discount discount1 = new DiscountCard();

        CreatingDiscountCardBaseFromFile discountCardBaseFromFile = new CreatingDiscountCardBaseFromFile();

        assertEquals(discount1.getClass(),discountCardBaseFromFile.creatingDiscountCardBaseFromFile(file).getClass());
    }

    @Test
    void TestCreatingDiscountCardBaseFromEmptyFile() {
        String file = "";

        Discount discount1 = new DiscountCard();

        CreatingDiscountCardBaseFromFile discountCardBaseFromFile = new CreatingDiscountCardBaseFromFile();

        assertEquals(discount1.getClass(),discountCardBaseFromFile.creatingDiscountCardBaseFromFile(file).getClass());
    }
    @Test
    void TestCreatingDiscountCardBaseFromUnrealFile() {
        String file = "unrealFile";

        Discount discount1 = new DiscountCard();

        CreatingDiscountCardBaseFromFile discountCardBaseFromFile = new CreatingDiscountCardBaseFromFile();

        assertEquals(discount1.getClass(),discountCardBaseFromFile.creatingDiscountCardBaseFromFile(file).getClass());
    }
}