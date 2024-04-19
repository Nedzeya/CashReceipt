package com.klachkova.cashReceipt.basket;

import com.klachkova.cashReceipt.discount.Discount;
import com.klachkova.cashReceipt.product.Product;

import java.util.Map;

public class DiscountCardBasket extends DecoratorDiscount{
    Discount discount;

    public DiscountCardBasket(Map<Integer, Product> basketMap, int numberOfDiscount) {
        super(basketMap);
        this.discount = discountMap.get(numberOfDiscount);
    }

    @Override
    public double totalOfBasket() {

        return super.totalOfBasket()*(100-getPercentsOfDiscount())/100;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(" ");
        for (Integer key : getBasketMap().keySet()) {
            sb.append(getBasketMap().get(key));
        }
        return String.format("%-4S %-20S %-8S %-8S\n\n","QTY","DESCRIPTION","PRICE", "TOTAL")
                + sb +
                "\n===========================================\n\n"+
                String.format("%-30S  %.2f\n %30s %.2f\n %30S %.2f",
                        "TOTAL",super.totalOfBasket(),"-",super.totalOfBasket()-totalOfBasket(),"$",totalOfBasket());
    }

    @Override
    public double getPercentsOfDiscount() {
        return this.discount.getPercentsOfDiscount();
    }

    @Override
    public int getNumberOfDiscount() {

        return this.discount.getNumberOfDiscount();
    }

    @Override
    public String getNameOfDiscount() {
        return this.discount.getNameOfDiscount();
    }

    @Override
    public Map<Integer, Product> getBasketMap() {
        return super.basketMap;
    }

    public Discount getDiscount() {
        return discount;
    }
}
