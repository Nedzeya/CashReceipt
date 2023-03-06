package data;

import discount.Discount;
import discount.DiscountCard;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiscountCardBaseFromFile implements DiscountBase{
    private   String nameOfFile;
    private String [] args;
    private Discount discount = new DiscountCard();

    public DiscountCardBaseFromFile() {
    }

    @Override
    public Discount readingFromFile(String filename) {
         this.nameOfFile = filename;

        try (FileReader reader = new FileReader("D:\\Programing\\GitHub\\CashReceipt\\" + this.nameOfFile)) {


            int c;
            List<Character> characterList = new ArrayList<>();
            while ((c = reader.read()) != -1) {
                characterList.add((char) c);
            }

            String string = new String();
            for (char ch : characterList) {
                string = string + ch;
            }

            this.args = string.split("\n");

            for (int i = 0; i < args.length; i++) {
                Integer numberOfCard = Integer.valueOf(args[i].substring(0, args[i].indexOf("-")));
                Double percentsOfDiscount = Double.valueOf(args[i].substring(args[i].indexOf("-") + 1));

                discount.addDiscount(new DiscountCard(percentsOfDiscount, numberOfCard));
            }


        } catch (IOException | StringIndexOutOfBoundsException ex) {
            System.out.println(ex.toString());

            System.out.println("incorrect name of file: " + this.nameOfFile);
        }







        return discount;
    }
}
