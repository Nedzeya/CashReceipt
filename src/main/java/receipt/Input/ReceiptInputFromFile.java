package receipt.Input;

import readerFromFile.ReaderFromFileIntoStringArray;
import readerFromFile.ReaderFromFileIntoStringArraySplitSpace;

public class ReceiptInputFromFile implements ReceiptInput {
    public ReceiptInputFromFile() {
    }

    @Override
    public String[] input(String nameOfFile) {

        ReaderFromFileIntoStringArray readerFromFile = new ReaderFromFileIntoStringArraySplitSpace();
        return readerFromFile.readFromFile(nameOfFile);
    }

}
