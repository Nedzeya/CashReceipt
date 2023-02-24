package receipt;

import basket.Basket;
import discount.Discount;
import product.ProductFactory;

public interface ReceiptInput {
    void input (String[] args, ProductFactory productFactory, Basket basket, Discount discount);
}
