package data;

import product.ProductFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductBaseFromFile implements ProductBase {
    private String nameOfFile;
    private String[] args;
    private ProductFactory productFactory = new ProductFactory();

    public ProductBaseFromFile() {
    }

    @Override
    public ProductFactory readingFromFile(String filename) {
        this.nameOfFile = filename;

        try (FileReader reader = new FileReader("D:\\Programing\\GitHub\\CashReceipt\\" + this.nameOfFile)) {
            System.out.println("filename " +filename);

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
            System.out.println("args were created");

            String action = "";
            Double priceOfProduct;

            for (int i = 0; i < args.length; i++) {

             int i1 = args[i].indexOf("-");
                Integer idOfProduct = Integer.valueOf(args[i].substring(0, i1));
                System.out.println("id of pr " + idOfProduct);

                int i2 = args[i].indexOf("-",i1+1);
                String nameOfProduct = args[i].substring(i1+1,i2) ;

                System.out.println("name of pr " +nameOfProduct);
                int i3=args[i].indexOf("-",i2+1);
                System.out.println("i3 =" + i3);
                if (i3>-1) {
                    System.out.println("- is");
                    priceOfProduct = Double.valueOf(args[i].substring(i2 + 1, i3));
                    System.out.println("price of or " + priceOfProduct);
                    action = args[i].substring(i3+1);
                    System.out.println("name of action " + action);
                } else{
                    System.out.println("no-");
                    priceOfProduct = Double.valueOf(args[i].substring(i2 + 1));
                    System.out.println("price of product " + priceOfProduct);
                    System.out.println(" no name of action " + action);
                }

                if (action.toLowerCase().contains("sixproducts")) {
                    System.out.println("creating action pr");
                    productFactory.createActionSixProductsProduct(idOfProduct, nameOfProduct, priceOfProduct);
                } else {
                    System.out.println("creating simple pr");

                    if (!action.trim().equals("")) {

                        System.out.println("Action \"" + action.trim()+ "\" not found. Creating of simple product");
                    }
                    productFactory.createSimpleProduct(idOfProduct, nameOfProduct, priceOfProduct);
                }
            }


        } catch (IOException | StringIndexOutOfBoundsException ex) {
            System.out.println(ex.toString());

            System.out.println("incorrect name of file: " + this.nameOfFile);
        }


        return productFactory;
    }
}
