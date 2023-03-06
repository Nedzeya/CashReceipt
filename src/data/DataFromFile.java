package data;

import discount.Discount;
import discount.DiscountCard;
import product.ProductFactory;

import java.util.Map;

public class DataFromFile implements Data {
    private String[] args;
    private Discount discount = new DiscountCard();
    private  ProductFactory productFactory = new ProductFactory();


    @Override
    public Discount discountData() {
                return discount;
    }

    @Override
    public ProductFactory productsData() {
        return productFactory;
    }
}
