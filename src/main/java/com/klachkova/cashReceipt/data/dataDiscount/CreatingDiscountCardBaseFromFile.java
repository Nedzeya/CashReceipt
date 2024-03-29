package com.klachkova.cashReceipt.data.dataDiscount;

import com.klachkova.cashReceipt.readerFromFile.ReaderFromFileIntoStringArray;
import com.klachkova.cashReceipt.readerFromFile.ReaderFromFileIntoStringArraySplitEnter;
import com.klachkova.cashReceipt.discount.Discount;
import com.klachkova.cashReceipt.discount.DiscountCard;

public class CreatingDiscountCardBaseFromFile implements DiscountBase {

    private String[] args;


    public CreatingDiscountCardBaseFromFile() {
    }


    private String[] readingDiscountCardBaseFromFile(String nameOfFile) {
        ReaderFromFileIntoStringArray readerFromFile = new ReaderFromFileIntoStringArraySplitEnter();
        return this.args = readerFromFile.readFromFile(nameOfFile);

    }

    FindingDataOfDiscountCardInArray findingDataOfDiscountCardInArray = new FindingDataOfDiscountCardInArray();


    @Override
    public Discount creatingDiscountCardBaseFromFile(String nameOfFile) {
        Discount discount = new DiscountCard();

        readingDiscountCardBaseFromFile(nameOfFile);
        Integer[] number = findingDataOfDiscountCardInArray.findingNumbersOfCards(args);
        Double[] percents = findingDataOfDiscountCardInArray.findingPercentsOfDiscount(args);

            for (int i = 0; i < this.args.length; i++) {
                if (percents[i] != null && number[i] != null) {
                    discount.addDiscount(new DiscountCard(percents[i], number[i]));
                } else {
                    System.out.println(" com.klachkova.cashReceipt.actions.discount cards base without data was created");
                }
            }
            return discount;

    }
}
