package data;

import discount.Discount;
import discount.DiscountCard;

import java.util.Map;

public class DataFromClass implements Data {
    Discount discount = new DiscountCard();

    @Override
    public Discount discountData() {
        discount.addDiscount(new DiscountCard(4, 1));
        discount.addDiscount(new DiscountCard(10, 2));

        return discount;
    }
//    @Override
//    public Map<Integer, Discount> discountData() {
//
//        discount.addDiscount(new DiscountCard(4, 1));
//        discount.addDiscount(new DiscountCard(10, 2));
//        return discount.getDiscountMap();
//    }
}
