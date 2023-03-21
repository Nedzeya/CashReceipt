package DataDiscountAndProducts.DataProducts;

public class FindingDataOfProductBaseInArray {

    public FindingDataOfProductBaseInArray() {
    }


    public Integer[] idsOfProduct(String[] args) {
        Integer[] idsOfProduct;

        idsOfProduct = new Integer[args.length];
        for (int i = 0; i < args.length; i++) {

            int i1 = args[i].indexOf("-");
            idsOfProduct[i] = Integer.valueOf(args[i].substring(0, i1));
        }
        return idsOfProduct;
    }

    public String[] namesOfProduct(String[] args) {
        String[] namesOfProduct;

        namesOfProduct = new String[args.length];
        for (int i = 0; i < args.length; i++) {

            int i1 = args[i].indexOf("-");
            int i2 = args[i].indexOf("-", i1 + 1);
            namesOfProduct[i] = args[i].substring(i1 + 1, i2);
        }
        return namesOfProduct;
    }

    public Double[] pricesOfProduct(String[] args) {
        Double[] pricesOfProduct;

        pricesOfProduct = new Double[args.length];
        for (int i = 0; i < args.length; i++) {
            int i1 = args[i].indexOf("-");
            int i2 = args[i].indexOf("-", i1 + 1);
            int i3 = args[i].indexOf("-", i2 + 1);
            //System.out.println("i3 =" + i3);
            if (i3 > -1) {
                //  System.out.println("- is");
                pricesOfProduct[i] = Double.valueOf(args[i].substring(i2 + 1, i3));
                //System.out.println("price of or " + priceOfProduct);

            } else {
                //System.out.println("no-");
                pricesOfProduct[i] = Double.valueOf(args[i].substring(i2 + 1));
                //System.out.println("price of main.java.product " + priceOfProduct);
                //System.out.println(" no name of action " + action);
            }

        }
        return pricesOfProduct;
    }


    public String gettingOfAction(String[] args) {
        String action = "";
        for (int i = 0; i < args.length; i++) {
            int i1 = args[i].indexOf("-");
            int i2 = args[i].indexOf("-", i1 + 1);
            int i3 = args[i].indexOf("-", i2 + 1);

            if (i3 > -1) {
                action = args[i].substring(i3 + 1);
            }
        }
        return action;
    }

}