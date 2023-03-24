package receipt.Output;

import org.junit.jupiter.api.Test;
import receipt.Input.ReceiptInput;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptOutputTest {

    int x = 0;
    Object object;
    class TestReceiptOutput implements ReceiptOutput{

        @Override
        public void output(Object object) {
           x = 1;
        }
    }
    @Test
    void output() {
        ReceiptOutput receiptOutput = new TestReceiptOutput();
        receiptOutput.output(object);
        assertEquals(1,x);
    }
}