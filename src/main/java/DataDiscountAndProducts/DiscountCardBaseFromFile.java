package DataDiscountAndProducts;

import discount.Discount;
import discount.DiscountCard;

public class DiscountCardBaseFromFile implements DiscountBase{
    //private   String nameOfFile;
    private String [] args;
    private Discount discount = new DiscountCard();


    public DiscountCardBaseFromFile() {
    }

    @Override
    public Discount addingDiscountCardBaseFromFile(String filename) {

        ReaderFromFile readerFromFile = new ReaderFromFile();
        this.args = readerFromFile.readingFromFileIntoStringArray(filename);

            for (int i = 0; i < args.length; i++) {
                Integer numberOfCard = Integer.valueOf(args[i].substring(0, args[i].indexOf("-")));
                Double percentsOfDiscount = Double.valueOf(args[i].substring(args[i].indexOf("-") + 1));

                discount.addDiscount(new DiscountCard(percentsOfDiscount, numberOfCard));
            }

        return discount;
    }
}
