package com.klachkova.cashReceipt.data.dataProducts;

import com.klachkova.cashReceipt.product.ProductFactory;

public interface ProductBase {
    ProductFactory creatingProductBaseFromFile(String nameOfFile);
}
