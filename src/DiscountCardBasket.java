public class DiscountCardBasket extends DecoratorDiscount{
DiscountCard discountCard;
    public DiscountCardBasket(Basket basket,int numberOfDiscount) {
        super(basket);
        this.discountCard.numberOfDiscount = numberOfDiscount;
       }

    @Override
    public double totalOfBasket() {
        return super.totalOfBasket()*getPercentsOfDiscount();
    }

    @Override
    public double getPercentsOfDiscount() {
        return this.discountCard.getPercentsOfDiscount();
    }

    @Override
    public int getNumberOfDiscount() {
        return this.discountCard.getNumberOfDiscount();
    }
}
