import DataDiscountAndProducts.DiscountBase;
import DataDiscountAndProducts.DiscountCardBaseFromFile;
import DataDiscountAndProducts.ProductBase;
import DataDiscountAndProducts.ProductBaseFromFile;
import basket.Basket;
import basket.DiscountCardBasket;
import discount.Discount;
import product.Product;
import product.ProductFactory;
import receipt.Input.ReceiptInput;
import receipt.Input.ReceiptInputFromFile;
import receipt.Receipt;


public class Main {


    public static void main(String[] args) {

//        args = new String[6];
//        args[0] = "products.txt";
//        args[1] = "2-1";
//        args[2] = "3-1";
//        args[3] = "card-2";
//       //  args[4] = "discountCards.txt";
//       // args[4] = "qqq";
//        args[4] = " ";
//        args[5] = "1-100";

//
         args = new String[3];
           args[0] = "receiptInput.txt";
        args[1] = "discountCards.txt";
        args [2]= "products.txt";

        ProductFactory productFactory;

        Basket basket = new Basket();
        ReceiptInput input;
        DiscountBase discountBase =  new DiscountCardBaseFromFile();
        ProductBase productBase =  new ProductBaseFromFile();
        Discount discount;


        int receiptInput = 0;

        String nameOfFileReceiptInput = "";

        String nameOfDiscountCardFile = "";
        String nameOfProductsBase ="";

        if (args.length > 0) {
            for (String s : args) {
                if (s.toLowerCase().contains("receiptinput")) {
                    receiptInput = 1;
                    nameOfFileReceiptInput = s;
                }

                if (s.toLowerCase().contains("discountcards")) {

                    nameOfDiscountCardFile = s;
                }

                if (s.toLowerCase().contains("products")) {
                    nameOfProductsBase= s;
                }

            }
            //System.out.println("receiptInput - " + receiptInput + "\n dataFromFile - " + dataFromFile);

            if (receiptInput == 1) {
                input = new ReceiptInputFromFile();
                args = input.input(nameOfFileReceiptInput);
            }
//            if (dataFromFile == 1) {
//                data = new DataFromFile(nameOfFileData);
//            }

//            if(dataDiscountCards ==1) {
//                main.java.discount = discountBase.readingFromFile(nameOfDiscountCardFile);
//            }


        }


        discount = discountBase.readingFromFile(nameOfDiscountCardFile);
        productFactory = productBase.readingFromFile(nameOfProductsBase);

        for (int i = 0; i < args.length; i++) {
            if (args[i] != null && !args[i].toLowerCase().contains(".txt")) {

                if (args[i].toLowerCase().contains("card-")) {

                    Integer numberOfCard = Integer.valueOf(args[i].substring(5));
                    //System.out.println("card we have " + args[i]);
                    basket = cardRecognition(basket, discount, numberOfCard);

                } else {
                    System.out.println("arg we are looking now " + args[i]);
                    try {
                        Integer idOfProduct = Integer.valueOf(args[i].substring(0, args[i].indexOf("-")));
                        Integer amountOfProduct = Integer.valueOf(args[i].substring(args[i].indexOf("-") + 1));

                        productRecognition(productFactory, basket, idOfProduct, amountOfProduct);
                    } catch (StringIndexOutOfBoundsException e) {
                        System.out.println("incorrect data information ");
                    }
                }
            }
        }

        Receipt receipt1 = new Receipt.ReceiptBuilder(basket)
                .setIsPrintInConsole(true)
                .setIsSaveInFile(false)
                .build();


    }

    static void productRecognition (ProductFactory productFactory,Basket basket,Integer idOfProduct, Integer amountOfProduct ){


        try {
            // System.out.println("main.java.product we have " + args[i]);

            // System.out.println("id of main.java.product is " + idOfProduct);

            // System.out.println("amount of main.java.product is " + amountOfProduct);
            if (productFactory.getProductMap().containsKey(idOfProduct)) {
                Product product = productFactory.getProductMap().get(idOfProduct);
                //  System.out.println("main.java.product start amount in map " + main.java.product.getAmountOfProduct());
                if (product.getAmountOfProduct() == 0) {

                    product.setAmountOfProduct(amountOfProduct);
                } else {
                    product.setAmountOfProduct(product.getAmountOfProduct() + amountOfProduct);
                }
                //   System.out.println("pr new amount in map " + main.java.product.getAmountOfProduct());

                basket.addProduct(product);
                // System.out.println("was added main.java.product  " + main.java.product);
            } else {
                System.out.println("there are no such main.java.product ");
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            System.out.println("incorrect  main.java.product");
        }
    }

    static Basket cardRecognition (Basket basket,Discount discount, Integer numberOfCard){
        try {

            //System.out.println("number of card is " + numberOfCard);
            if (discount.getDiscountMap().containsKey(numberOfCard)) {
                return new DiscountCardBasket(basket.getBasketMap(), numberOfCard);

            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            System.out.println("incorrect number of card");
        }
        return basket;
    }
}