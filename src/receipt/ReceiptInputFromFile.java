package receipt;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReceiptInputFromFile implements ReceiptInput {
    private String[] args;

    public ReceiptInputFromFile() {
    }

    @Override
    public String[] input(String[] args) {

        this.args = args;


        try (FileReader reader = new FileReader("D:\\Programing\\GitHub\\CashReceipt\\" + args[0])) {


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



//            for (String s: this.args ) {
//                System.out.println(s);
//            }


        } catch (IOException|StringIndexOutOfBoundsException ex) {
            System.out.println(ex.toString());

            System.out.println("incorrect name of file: " + args[0]);
        }

        return this.args;
    }





}
