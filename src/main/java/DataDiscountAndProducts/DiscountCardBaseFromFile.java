package DataDiscountAndProducts;

import discount.Discount;
import discount.DiscountCard;

public class DiscountCardBaseFromFile implements DiscountBase {
    private String nameOfFile;
    private String[] args;
    private Discount discount = new DiscountCard();

    public DiscountCardBaseFromFile() {
    }


    public DiscountCardBaseFromFile(String nameOfFile) {
        this.nameOfFile = nameOfFile;

    }


    private String[] readingDiscountCardBaseFromFile(String nameOfFile) {
        ReaderFromFile readerFromFile = new ReaderFromFile();
        return this.args = readerFromFile.readingFromFileIntoStringArray(nameOfFile);

    }

    FindingDataOfDiscountCardInArray findingDataOfDiscountCardInArray = new FindingDataOfDiscountCardInArray();

       public void addingDiscountCardBase(Integer[] number, Double[] percents) {

        for (int i = 0; i < this.args.length; i++) {
            discount.addDiscount(new DiscountCard(percents[i], number[i]));
        }

    }


    @Override
    public Discount creatingDiscountCardBaseFromFile() {

        readingDiscountCardBaseFromFile(nameOfFile);
        Integer[] number = findingDataOfDiscountCardInArray.findingNumbersOfCards(args);
        Double[] percents = findingDataOfDiscountCardInArray.findingPercentsOfDiscount(args);
        addingDiscountCardBase(number, percents);
        return discount;
    }
}
