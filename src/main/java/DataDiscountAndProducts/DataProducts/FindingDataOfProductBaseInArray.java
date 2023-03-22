package DataDiscountAndProducts.DataProducts;

public class FindingDataOfProductBaseInArray {

    public FindingDataOfProductBaseInArray() {
    }


    public Integer[] idsOfProduct(String[] args) {
        Integer[] idsOfProduct;

        if (args!= null) {

            idsOfProduct = new Integer[args.length];
            for (int i = 0; i < args.length; i++) {

                int i1 = args[i].indexOf("-");
                idsOfProduct[i] = Integer.valueOf(args[i].substring(0, i1));
            }
            return idsOfProduct;
        } else {
            System.out.println("Array of IDs of Products is null");
            return null;
        }

    }

    public String[] namesOfProduct(String[] args) {
        String[] namesOfProduct;
        if (args!= null) {
        namesOfProduct = new String[args.length];
        for (int i = 0; i < args.length; i++) {

            int i1 = args[i].indexOf("-");
            int i2 = args[i].indexOf("-", i1 + 1);
            namesOfProduct[i] = args[i].substring(i1 + 1, i2);
        }
        return namesOfProduct;
        } else {
            System.out.println("Array of names of products is null");
            return null;
        }

    }

    public Double[] pricesOfProduct(String[] args) {
        Double[] pricesOfProduct;
        if (args!= null) {
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
        } else {
            System.out.println("Array of prices of products is null");
            return null;
        }
    }


    public String [] gettingOfAction(String[] args) {
        String []actions;
        if (args!= null) {
        actions = new String[args.length];

        for (int i = 0; i < args.length; i++) {
            int i1 = args[i].indexOf("-");
            int i2 = args[i].indexOf("-", i1 + 1);
            int i3 = args[i].indexOf("-", i2 + 1);

            if (i3 > -1) {
                actions[i] = args[i].substring(i3 + 1);
            } else {
                actions[i] = "";
            }
        }
        return actions;
        } else {
            System.out.println("Array of actions of products is null");
            return null;
        }
    }

}