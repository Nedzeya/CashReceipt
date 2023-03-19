package DataDiscountAndProducts;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderFromFile {
   // private   String nameOfFile;
   // private String [] args;

  //  private List characterList ;


    private List <Character> readingFromFileIntoList (String fileName) {
        List<Character> characterList = new ArrayList<>();
        try (FileReader reader = new FileReader(fileName)) {
//"D:\\Programing\\GitHub\\CashReceipt\\" +
            int c;
            while ((c = reader.read()) != -1) {
                characterList.add((char) c);
            }
        } catch (IOException | StringIndexOutOfBoundsException ex) {

            System.out.println(ex);

            System.out.println("incorrect name of file: " + fileName);
        }

        return characterList;
    }
    //  this.characterList = new ArrayList<>(characterList);

       private String [] fromListIntoStringArray (List list){

            String string = new String();
            for (Object ch : list) {
                string = string + ch;
            }

           return string.split("\n");
    }


}
