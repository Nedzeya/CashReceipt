package com.klachkova.cashReceipt.data.dataDiscount;

import com.klachkova.cashReceipt.discount.Discount;

public interface DiscountBase {
    Discount creatingDiscountCardBaseFromFile(String nameOfFile);
}
