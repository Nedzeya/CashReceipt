package DataDiscountAndProducts.DataProducts;

import DataDiscountAndProducts.ReaderFromFile;
import product.ProductFactory;

public class CreatingProductBaseFromFile implements ProductBase {

    private String[] args;
    private ProductFactory productFactory = new ProductFactory();

    public CreatingProductBaseFromFile() {

    }

    private void readingProductBaseFromFile(String nameOfFile) {
        ReaderFromFile readerFromFile = new ReaderFromFile();
        this.args = readerFromFile.readingFromFileIntoStringArray(nameOfFile);
    }

FindingDataOfProductBaseInArray findingDataOfProductBaseInArray = new FindingDataOfProductBaseInArray();
    @Override
    public ProductFactory creatingProductBaseFromFile(String nameOfFile) {


        readingProductBaseFromFile(nameOfFile);

        Integer [] idsOfProducts = findingDataOfProductBaseInArray.idsOfProduct(args);
        String [] namesOfProducts = findingDataOfProductBaseInArray.namesOfProduct(args);
        Double [] pricesOfProducts = findingDataOfProductBaseInArray.pricesOfProduct(args);
        String action = findingDataOfProductBaseInArray.gettingOfAction(args);

        ProductFactory productFactory = new ProductFactory();

        for (int i = 0; i < args.length; i++) {

            if (action.toLowerCase().contains("sixproducts")) {
                //System.out.println("creating action pr");
                productFactory.createActionSixProductsProduct(idsOfProducts[i], namesOfProducts[i], pricesOfProducts[i]);
            } else {
                //System.out.println("creating simple pr");

                if (!action.trim().equals("")) {

                    //  System.out.println("Action \"" + action.trim()+ "\" not found. Creating of simple main.java.product");
                }
                productFactory.createSimpleProduct(idsOfProducts[i], namesOfProducts[i], pricesOfProducts[i]);
            }
        }
        return productFactory;
    }
}
