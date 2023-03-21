package DataDiscountAndProducts.DataDiscount;

public class FindingDataOfDiscountCardInArray {

    public FindingDataOfDiscountCardInArray() {
    }

    public Integer[] findingNumbersOfCards(String[] args) {

        Integer[] numbersOfCards;
       // System.out.println("args length " + args.length);
        if (args != null && args.length>0 && !args[0].isEmpty() ) {
            numbersOfCards = new Integer[args.length];

            for (int i = 0; i < args.length; i++) {
                numbersOfCards[i] = Integer.valueOf(args[i].substring(0, args[i].indexOf("-")));
            }
            return numbersOfCards;
        } else {

           if(args == null) {
               System.out.println("numbers of cards is null");
               return null;
           }
            System.out.println("There are no numbers of discount cards");
        }

        return new Integer[args.length];
    }

    //4)
    public Double[] findingPercentsOfDiscount(String[] args) {

        Double[] percentsOfDiscount ;
        if (args != null && args.length>0 && !args[0].isEmpty()  ) {
            percentsOfDiscount =  new Double[args.length];
            for (int i = 0; i < args.length; i++) {
                percentsOfDiscount[i] = Double.valueOf(args[i].substring(args[i].indexOf("-") + 1));
            }
            return percentsOfDiscount;

        } else {
            if(args == null) {
                System.out.println("percents of cards is null");
                return null;
            }
            System.out.println("There are no percents of discount cards");
        }
        return new Double[args.length];
    }
}
