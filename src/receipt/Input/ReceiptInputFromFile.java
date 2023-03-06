package receipt.Input;



import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReceiptInputFromFile implements ReceiptInput {
    private String[] args;
  private   String nameOfFile;

    public ReceiptInputFromFile() {
    }

    @Override
    public String[] input(String nameOfFile) {

        this.nameOfFile = nameOfFile;



        try (FileReader reader = new FileReader("D:\\Programing\\GitHub\\CashReceipt\\" + nameOfFile)) {


                int c;
                List<Character> characterList = new ArrayList<>();
                while ((c = reader.read()) != -1) {
                    characterList.add((char) c);
                }

                String string = new String();
                for (char ch : characterList) {
                    string = string + ch;
                }

                String[] split = string.split(" ");
                this.args = Arrays.copyOf(split, split.length);



        } catch (IOException|StringIndexOutOfBoundsException ex) {
            System.out.println(ex.toString());

            System.out.println("incorrect name of file: " + nameOfFile);
        }

        return this.args;
    }





}
