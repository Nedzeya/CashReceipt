package com.klachkova.cashReceipt.product;

import com.klachkova.cashReceipt.actions.Actions;

public class ActionProduct extends Product {

    Actions action;

    public ActionProduct(int idOfProduct, String nameOfProduct, double priceOfProduct, Actions action) {
        super(idOfProduct, nameOfProduct, priceOfProduct);
        this.action = action;
    }

    public Actions getAction() {
        return action;
    }

    public void setAction(Actions action) {
        this.action = action;
    }

    @Override
    public double totalPriceOfProduct() {
        if (getAmountOfProduct() >= action.getCountOfProduct()) {
            return getPriceOfProduct() * getAmountOfProduct() * ( (100-action.getPercents())/100 );
        } else {
            return getPriceOfProduct() * getAmountOfProduct();
        }


    }

    @Override
    public String toString() {
        double totalPriceOfPrWithoutAct = getPriceOfProduct() * getAmountOfProduct();
        double sumOfAction = totalPriceOfPrWithoutAct-totalPriceOfProduct();
        if (getAmountOfProduct() >= action.getCountOfProduct()) {
            return String.format("%-3d %-20s $%-8.2f %-8.2f\n %35s%.2f\n %35s%.2f\n ", getAmountOfProduct(), getNameOfProduct(),
                    getPriceOfProduct(), totalPriceOfPrWithoutAct,"-",sumOfAction,"$",totalPriceOfProduct());

        } else {
            return String.format("%-3d %-20s $%-8.2f $%-8.2f\n ", getAmountOfProduct(), getNameOfProduct(),
                    getPriceOfProduct(), totalPriceOfProduct());
        }
    }
}
