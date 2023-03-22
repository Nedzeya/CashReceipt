package discount;



public class DiscountCard implements Discount {
    private double percentsOfDiscount;
    private int numberOfDiscount;
    private String nameOfDiscount = "DiscountCardOfClient";


    public DiscountCard() {
    }

    public DiscountCard(double percentsOfDiscount, int numberOfDiscount) {
        if (percentsOfDiscount >=0 && numberOfDiscount >=0) {
            this.percentsOfDiscount = percentsOfDiscount;
            this.numberOfDiscount = numberOfDiscount;
        } else {
            System.out.println("Was entered a negative number. There are can be only positive numbers. It will be converted into positive");
            this.percentsOfDiscount = percentsOfDiscount * -1;
            this.numberOfDiscount = numberOfDiscount * -1;
        }
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
