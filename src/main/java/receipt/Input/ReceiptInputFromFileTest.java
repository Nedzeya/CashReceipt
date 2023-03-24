package receipt.Input;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptInputFromFileTest {
    String file;
    String[] strings = {"test"};
    @Test
    void input() {
        ReceiptInputFromFile receiptInputFromFile = new ReceiptInputFromFile();

        assertEquals(strings.getClass(),receiptInputFromFile.input(file).getClass());
    }
}