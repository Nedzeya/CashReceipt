package data;

import discount.Discount;
import discount.DiscountCard;
import product.ProductFactory;

public class DataFromClass implements Data {
    private Discount discount = new DiscountCard();
  private  ProductFactory productFactory = new ProductFactory();

    @Override
    public Discount discountData() {
        discount.addDiscount(new DiscountCard(4, 1));
        discount.addDiscount(new DiscountCard(10, 2));

        return discount;
    }

    @Override
    public ProductFactory productsData() {
        productFactory.createActionSixProduct(1, "Nicest Person", 888);
        productFactory.createActionSixProduct(2, "Best Looking", 98);
        productFactory.createSimpleProduct(3, "Best Face", 978);
        productFactory.createSimpleProduct(4, "Great Smile", 9);

        return productFactory;
    }
}
