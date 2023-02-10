public class DiscountCard implements Discount{
    double percentsOfDiscount;
    int numberOfDiscount;

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
}
