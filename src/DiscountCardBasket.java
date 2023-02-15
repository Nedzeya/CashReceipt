import java.util.HashMap;
import java.util.Map;

public class DiscountCardBasket extends DecoratorDiscount{


Discount discount;
    public DiscountCardBasket(Basket basket,int numberOfDiscount) {
        super(basket);
        this.discount = discountMap.get(numberOfDiscount);
       }

    @Override
    public double totalOfBasket() {

        return super.totalOfBasket()*getPercentsOfDiscount();
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
}
