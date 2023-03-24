package readerFromFile;

import java.util.List;

public class ReaderFromFileIntoStringArraySplitEnter implements ReaderFromFileIntoStringArray {


    @Override
    public String[] readFromFile(String fileName) {

        if (fileName == null && fileName == "") {
            System.out.println("File name cannot be null or empty.");
        }
        return fromCharListIntoStringArraySplitEnter(readingFromFileIntoList(fileName));

    }

    public String[] fromCharListIntoStringArraySplitEnter(List list) {

            String string = new String();
        try { for (Object ch : list) {
                string = string + ch;
            }

        } catch( NullPointerException ex) {
        System.out.println("List shouldn't be null ");
    }
        return string.split("\n");
}


}
