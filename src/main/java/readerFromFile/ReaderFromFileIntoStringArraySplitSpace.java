package readerFromFile;

import java.util.List;

public class ReaderFromFileIntoStringArraySplitSpace implements ReaderFromFileIntoStringArray{
    @Override
    public String[] readFromFile(String fileName) {
        return fromListIntoStringArraySplitSpace(readingFromFileIntoList(fileName));
    }

    private String [] fromListIntoStringArraySplitSpace(List list){

        String string = new String();
        for (Object ch : list) {
            string = string + ch;
        }

        return string.split(" ");
    }

}
