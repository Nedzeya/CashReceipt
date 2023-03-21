package DataDiscountAndProducts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindingDataOfDiscountCardInArrayTest {
    FindingDataOfDiscountCardInArray findingDataOfDiscountCardInArray = new FindingDataOfDiscountCardInArray();
    @Test
    void TestFindingNumbersOfCardsInFullArray() {
        String[] args = {"3-1", "4-5", "1-2"};
        Integer[] numbersOfCards = {3,4,1};
        for (int i = 0; i < args.length; i++) {
            assertEquals(numbersOfCards[i],findingDataOfDiscountCardInArray.findingNumbersOfCards(args)[i]);
        }

    }


    @Test
    void TestFindingNumbersOfCardsInEmptyArray() {
        String[] args = {};
        assertEquals(0,findingDataOfDiscountCardInArray.findingNumbersOfCards(args).length);
    }

    @Test
    void TestFindingNumbersOfCardsInNullArray() {
        String[] args = null;
        assertEquals(null,findingDataOfDiscountCardInArray.findingNumbersOfCards(args));
    }


    @Test
    void TestFindingPercentsOfDiscountInFullArray() {

        String[] args = {"3-1", "4-5", "1-2"};
        Double[] percentsOfDiscount = {1.0,5.0,2.0};
        for (int i = 0; i < args.length; i++) {
            assertEquals(percentsOfDiscount[i],findingDataOfDiscountCardInArray.findingPercentsOfDiscount(args)[i]);
        }

    }

    @Test
    void TestFindingPercentsOfDiscountInInEmptyArray() {
        String[] args = {};
            assertEquals(0,findingDataOfDiscountCardInArray.findingPercentsOfDiscount(args).length);
    }

    @Test
    void TestFindingPercentsOfDiscountInInNullArray() {
        String[] args = null;
        assertEquals(null,findingDataOfDiscountCardInArray.findingPercentsOfDiscount(args));
    }


}