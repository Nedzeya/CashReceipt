package DataDiscountAndProducts.DataProducts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindingDataOfProductBaseInArrayTest {
    FindingDataOfProductBaseInArray findingDataOfProductBaseInArray = new FindingDataOfProductBaseInArray();

    @Test
    void TestIdsOfProductInFullArray() {
        String[] args = {"1-Nice-100-SixProducts",
                "2-Cool-200-SixProducts",
                "3-Good-130-OneProduct",
                "4-Fine-104-",
                "5-Normal-500"};
        Integer[] idsOfProduct = {1, 2, 3,4,5};
        for (int i = 0; i < args.length; i++) {
            assertEquals(idsOfProduct[i], findingDataOfProductBaseInArray.idsOfProduct(args)[i]);
        }
    }

    @Test
    void TestIdsOfProductInEmptyArray() {
        String[] args = {};

        for (int i = 0; i < args.length; i++) {
            assertEquals(0, findingDataOfProductBaseInArray.idsOfProduct(args).length);
        }
    }

    @Test
    void TestIdsOfProductInNullArray() {
        String[] args = null;
        assertEquals(null, findingDataOfProductBaseInArray.idsOfProduct(args));
    }

    @Test
    void TestNamesOfProductInFullArray() {
        String[] args = {"1-Nice-100-SixProducts",
                "2-Cool-200-SixProducts",
                "3-Good-130-OneProduct",
                "4-Fine-104-",
                "5-Normal-500"};
        String[] namesOfProduct = {"Nice", "Cool","Good","Fine","Normal"};
        for (int i = 0; i < args.length; i++) {
            assertEquals(namesOfProduct[i], findingDataOfProductBaseInArray.namesOfProduct(args)[i]);
        }

    }

    @Test
    void TestNamesOfProductInEmptyArray() {
        String[] args = {};
            assertEquals(0, findingDataOfProductBaseInArray.namesOfProduct(args).length);
    }

    @Test
    void TestNamesOfProductInNullArray() {
        String[] args = null;
        assertEquals(null, findingDataOfProductBaseInArray.namesOfProduct(args));
    }
    @Test
    void TestPricesOfProductInFullArray() {
        String[] args = {"1-Nice-100-SixProducts",
                "2-Cool-200-SixProducts",
                "3-Good-130-OneProduct",
                "4-Fine-104-",
                "5-Normal-500"};
        Double[] pricesOfProduct = {100.0, 200.0,130.0,104.0,500.0};
        for (int i = 0; i < args.length; i++) {
            assertEquals(pricesOfProduct[i], findingDataOfProductBaseInArray.pricesOfProduct(args)[i]);
        }
    }

    @Test
    void TestPricesOfProductInEmptyArray() {
        String[] args = {};
                   assertEquals(0, findingDataOfProductBaseInArray.pricesOfProduct(args).length);
            }
    @Test
    void TestPricesOfProductInNullArray() {
        String[] args = null;
        assertEquals(null, findingDataOfProductBaseInArray.pricesOfProduct(args));
    }
    @Test
    void TestGettingOfActionInFullArray() {
        String[] args = {"1-Nice-100-SixProducts",
                "2-Cool-200-SixProducts",
                "3-Good-130-OneProduct",
                "4-Fine-104-",
                "5-Normal-500"};
        String [] actions = {"SixProducts","SixProducts","OneProduct","",""};
        for (int i = 0; i < args.length; i++) {
            assertEquals(actions[i], findingDataOfProductBaseInArray.gettingOfAction(args)[i]);
        }
    }

    @Test
    void TestGettingOfActionInEmptyArray() {
        String[] args = {};
            assertEquals(0, findingDataOfProductBaseInArray.gettingOfAction(args).length);
        }
    @Test
    void TestGettingOfActionInNullArray() {
        String[] args = null;
        assertEquals(null, findingDataOfProductBaseInArray.gettingOfAction(args));
    }
    }