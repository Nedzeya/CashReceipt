package com.klachkova.cashReceipt.actions;

public class ActionSixProducts implements Actions {
    String nameOfAction = "Six products";
    double percents = 10;
     int countOfProduct = 6;



    @Override
    public String getNameOfAction() {

        return this.nameOfAction;
    }

    @Override
    public double getPercents() {

        return this.percents;
    }

    @Override
    public int getCountOfProduct() {

        return this.countOfProduct;
    }
}
