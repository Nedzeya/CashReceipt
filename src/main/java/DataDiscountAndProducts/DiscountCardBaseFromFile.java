package DataDiscountAndProducts;

import discount.Discount;
import discount.DiscountCard;

import java.util.Arrays;

public class DiscountCardBaseFromFile implements DiscountBase{

    private String [] args;
    private Discount discount = new DiscountCard();


    public DiscountCardBaseFromFile(String nameOfFile) {
        ReaderFromFile readerFromFile = new ReaderFromFile();
        this.args = readerFromFile.readingFromFileIntoStringArray(nameOfFile);
    }



    @Override
    public Discount addingDiscountCardBaseFromFile() {


            for (int i = 0; i < args.length; i++) {
                Integer numberOfCard = Integer.valueOf(args[i].substring(0, args[i].indexOf("-")));
                Double percentsOfDiscount = Double.valueOf(args[i].substring(args[i].indexOf("-") + 1));

                discount.addDiscount(new DiscountCard(percentsOfDiscount, numberOfCard));
            }

        return discount;
    }
}
