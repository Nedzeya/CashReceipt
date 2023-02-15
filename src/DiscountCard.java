import java.util.HashMap;
import java.util.Map;

public class DiscountCard implements Discount{
    double percentsOfDiscount;
    int numberOfDiscount;
    String nameOfDiscount = "DiscountCardOfClient";

    public DiscountCard(double percentsOfDiscount, int numberOfDiscount) {
        this.percentsOfDiscount = percentsOfDiscount;
        this.numberOfDiscount = numberOfDiscount;

        discountMap.putIfAbsent(this.getNumberOfDiscount(), new DiscountCard(this.getPercentsOfDiscount(),this.getNumberOfDiscount()));
    }

    @Override
    public double getPercentsOfDiscount() {

        return this.percentsOfDiscount;
    }

    @Override
    public int getNumberOfDiscount() {

        return this.numberOfDiscount;
    }

    @Override
    public String getNameOfDiscount() {
        return this.nameOfDiscount;
    }
}
