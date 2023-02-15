abstract class DecoratorDiscount extends Basket implements Discount {

    protected Basket basket;

    public DecoratorDiscount(Basket basket){

        this.basket = basket;
    }

   public double totalOfBasket (){

        return this.basket.totalOfBasket();
    }
}
