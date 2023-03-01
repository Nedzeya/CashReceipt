package basket;

import discount.Discount;
import product.Product;

import java.util.Map;

public class DiscountCardBasket extends DecoratorDiscount{


    Discount discount;


public DiscountCardBasket(Basket basket){
    super(basket);
}

    public DiscountCardBasket(Map<Integer, Product> basketMap, int numberOfDiscount) {
        super(basketMap);
        this.discount = discountMap.get(numberOfDiscount);
    }




    @Override
    public double totalOfBasket() {
            return ( (super.totalOfBasket())*(100-getPercentsOfDiscount())/100);
    }

//    @Override
//    public String toString (){
//
//        StringBuilder sb = new StringBuilder(" ");
//        for (Integer key : getBasketMap().keySet()) {
//            sb.append(getBasketMap().get(key));
//        }
//        return String.format("%-4S %-20S %-8S %-8S\n\n","QTY","DESCRIPTION","PRICE", "TOTAL")
//                + sb +
//                "\n===========================================\n\n"+
//                String.format("%-30S %S %.2f","TOTAL","$",totalOfBasket());
//    }
//    @Override
//    public String toString (){
//        return super.toString();
//    }

    @Override
    public String toString (){
        return "super.toString()";
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
}
