package DataDiscountAndProducts;

public class FindingDataOfDiscountCardInArray {

    public FindingDataOfDiscountCardInArray() {
    }

    public Integer[] findingNumbersOfCards(String[] args) {

        Integer[] numbersOfCards = new Integer[args.length];

        if (args != null && !args[0].isEmpty()) {
            for (int i = 0; i < args.length; i++) {
                numbersOfCards[i] = Integer.valueOf(args[i].substring(0, args[i].indexOf("-")));
            }

        } else {
            System.out.println("There are no numbers of cards");
        }
        return numbersOfCards;
    }

    //4)
    public Double[] findingPercentsOfDiscount(String[] args) {

        Double[] percentsOfDiscount = new Double[args.length];
        if (args != null && !args[0].isEmpty()) {
            for (int i = 0; i < args.length; i++) {
                percentsOfDiscount[i] = Double.valueOf(args[i].substring(args[i].indexOf("-") + 1));
            }

        } else {
            System.out.println("There are no percents of discount cards");
        }
        return percentsOfDiscount;
    }
}
