package com.klachkova.cashReceipt.data.dataDiscount;

import com.klachkova.cashReceipt.discount.Discount;
import com.klachkova.cashReceipt.discount.DiscountCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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