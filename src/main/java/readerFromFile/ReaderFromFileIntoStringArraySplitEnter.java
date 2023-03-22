package readerFromFile;

import java.util.List;

public class ReaderFromFileIntoStringArraySplitEnter implements ReaderFromFileIntoStringArray {

    @Override
    public String[] readFromFile(String fileName) {
        return fromListIntoStringArraySplitEnter(readingFromFileIntoList(fileName));
    }
    private String [] fromListIntoStringArraySplitEnter(List list){

            String string = new String();
            for (Object ch : list) {
                string = string + ch;
            }

           return string.split("\n");
    }



}
