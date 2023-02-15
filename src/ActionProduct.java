public class ActionProduct extends Product {

    Actions action;

    public ActionProduct(int idOfProduct, String nameOfProduct, double priceOfProduct, int amountOfProduct, Actions action) {
        super(idOfProduct, nameOfProduct, priceOfProduct, amountOfProduct);
        this.action = action;
    }

    public Actions getAction() {
        return action;
    }

    public void setAction(Actions action) {
        this.action = action;
    }

    @Override
    protected double totalPriceOfProduct() {
        if (getAmountOfProduct() > 5) {
            return getPriceOfProduct() * getAmountOfProduct() * 0.9;
        } else {
            return getPriceOfProduct() * getAmountOfProduct();
        }


    }

    @Override
    public String toString() {
        double totalPriceOfPrWithoutAct = getPriceOfProduct() * getAmountOfProduct();
        double sumOfAction = totalPriceOfPrWithoutAct-totalPriceOfProduct();
        if (getAmountOfProduct() > 5) {
            return String.format("%-3d %-20s $%-8.2f %-8.2f\n %35s%.2f\n %35s%.2f\n ", getAmountOfProduct(), getNameOfProduct(),
                    getPriceOfProduct(), totalPriceOfPrWithoutAct,"-",sumOfAction,"$",totalPriceOfProduct());

        } else {
            return String.format("%-3d %-20s $%-8.2f $%-8.2f\n ", getAmountOfProduct(), getNameOfProduct(),
                    getPriceOfProduct(), totalPriceOfProduct());
        }
    }
}
