package data;

import discount.Discount;
import discount.DiscountCard;
import product.ProductFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DataFromFile implements Data {
    private String[] args;
    private   String nameOfFile;
    private Discount discount = new DiscountCard();
    private  ProductFactory productFactory = new ProductFactory();

    public DataFromFile(String nameOfFile) {
        this.nameOfFile = nameOfFile;

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

            String[] split = string.split(" ");
            this.args = Arrays.copyOf(split, split.length);



        } catch (IOException | StringIndexOutOfBoundsException ex) {
            System.out.println(ex.toString());

            System.out.println("incorrect name of file: " + nameOfFile);
        }
    }



    @Override
    public Discount discountData() {
                return discount;
    }

    @Override
    public ProductFactory productsData() {
        return productFactory;
    }
}
