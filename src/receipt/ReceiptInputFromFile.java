package receipt;

import basket.Basket;
import discount.Discount;
import product.ProductFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReceiptInputFromFile implements ReceiptInput {
    private String[] args;
    private ProductFactory productFactory;
    private Basket basket;
    private Discount discount;


    public ReceiptInputFromFile() {
    }

    @Override
    public void input(String[] args, ProductFactory productFactory, Discount discount) {

        this.args = args;
        this.productFactory = productFactory;
        this.basket = basket;
        this.discount = discount;


        try (FileReader reader = new FileReader("D:\\Programing\\GitHub\\CashReceipt\\"+args[0])){


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

                new ReceiptInputFromConsole().input(this.args, this.productFactory, this.discount);


        } catch (IOException|StringIndexOutOfBoundsException ex) {
            System.out.println(ex.toString());

            System.out.println("incorrect name of file: " + args[0]);
        }
    }
}
