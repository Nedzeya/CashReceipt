package DataDiscountAndProducts;

public class FindingDataOfDiscountCardInArray {

    public FindingDataOfDiscountCardInArray() {
    }

    public Integer[] findingNumbersOfCards(String [] args) {

        Integer[] numbersOfCards = new Integer[args.length];

        for (int i = 0; i < args.length; i++) {
            numbersOfCards[i] = Integer.valueOf(args[i].substring(0, args[i].indexOf("-")));
        }
        return numbersOfCards;
    }

    //4)
    public Double[] findingPercentsOfDiscount( String [] args) {

        Double[] percentsOfDiscount = new Double[args.length];

        for (int i = 0; i < args.length; i++) {
            percentsOfDiscount[i] = Double.valueOf(args[i].substring(args[i].indexOf("-") + 1));
        }
        return percentsOfDiscount;
    }
}
