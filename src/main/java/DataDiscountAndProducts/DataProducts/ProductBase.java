package DataDiscountAndProducts.DataProducts;

import product.ProductFactory;

public interface ProductBase {
    ProductFactory creatingProductBaseFromFile(String nameOfFile);
}
