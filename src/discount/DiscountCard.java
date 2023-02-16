package discount;

import discount.Discount;

public class DiscountCard implements Discount {
    private double percentsOfDiscount;
    private int numberOfDiscount;
    private String nameOfDiscount = "DiscountCardOfClient";


    public DiscountCard() {
    }

    public DiscountCard(double percentsOfDiscount, int numberOfDiscount) {
        this.percentsOfDiscount = percentsOfDiscount;
        this.numberOfDiscount = numberOfDiscount;
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
