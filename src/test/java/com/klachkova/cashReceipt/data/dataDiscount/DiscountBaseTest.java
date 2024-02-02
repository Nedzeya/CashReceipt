package com.klachkova.cashReceipt.data.dataDiscount;

import com.klachkova.cashReceipt.discount.Discount;
import com.klachkova.cashReceipt.discount.DiscountCard;
import org.junit.jupiter.api.Test;

class DiscountBaseTest {
    Discount discount1 = new DiscountCard();
    String file;

    class TestDiscountBase implements DiscountBase{

        @Override
        public Discount creatingDiscountCardBaseFromFile(String file) {

            return discount1;
        }
    }

    @Test
    void TestCreatingDiscountCardBaseFromFile() {
        DiscountBase discountBase = new TestDiscountBase();

        assertEquals(discount1,discountBase.creatingDiscountCardBaseFromFile(file));
    }


}