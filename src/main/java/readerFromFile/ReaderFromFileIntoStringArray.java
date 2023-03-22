package readerFromFile;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface ReaderFromFileIntoStringArray {

    String [] readFromFile (String fileName);

   default List<Character> readingFromFileIntoList(String fileName) {
        List<Character> characterList = new ArrayList<>();
        try (FileReader reader = new FileReader(fileName)) {
//"D:\\Programing\\GitHub\\CashReceipt\\" +
            int c;
            while ((c = reader.read()) != -1) {
                characterList.add((char) c);
            }
        } catch (IOException | StringIndexOutOfBoundsException | NullPointerException  ex) {

            System.out.println("incorrect name of file or file does not exist: " + fileName);
        }

        return characterList;
    }

}
