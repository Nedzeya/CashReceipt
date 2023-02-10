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
        if (amountOfProduct > 5) {
            return priceOfProduct * amountOfProduct * 0.9;
        } else {
            return priceOfProduct * amountOfProduct;
        }
    }

    @Override
    public String toString() {
        if (amountOfProduct > 5) {
            return amountOfProduct + " %-10s" + nameOfProduct + " %-10s$" + priceOfProduct +
                    " %-10s$" + totalPriceOfProduct() * 1.1 +
                    "%n%-30 -" + ((totalPriceOfProduct() * 1.1) - totalPriceOfProduct())
                    + "%n%-30" + totalPriceOfProduct();
        } else {
            return amountOfProduct + " %-10s" + nameOfProduct + " %-10s$" + priceOfProduct +
                    " %-10s$" + totalPriceOfProduct();
        }
    }
}
