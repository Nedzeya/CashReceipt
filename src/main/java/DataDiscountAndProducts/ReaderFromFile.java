package DataDiscountAndProducts;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderFromFile {

    public String[] readingFromFileIntoStringArray(String nameOfFile) {
        return fromListIntoStringArray(readingFromFileIntoList(nameOfFile));

    }


    private List<Character> readingFromFileIntoList(String fileName) {
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


    private String [] fromListIntoStringArray (List list){

            String string = new String();
            for (Object ch : list) {
                string = string + ch;
            }

           return string.split("\n");
    }


}
