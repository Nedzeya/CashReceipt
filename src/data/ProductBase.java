package data;

import product.ProductFactory;

public interface ProductBase {
    ProductFactory readingFromFile (String filename);
}
