import basket.Basket;
import basket.DiscountCardBasket;
import data.*;
import discount.Discount;
import product.Product;
import product.ProductFactory;
import receipt.Input.ReceiptInput;
import receipt.Input.ReceiptInputFromFile;
import receipt.Receipt;


public class Main {


    public static void main(String[] args) {

//        args = new String[4];
//        args[0] = "1-100";
//        args[1] = "2-1";
//        args[2] = "3-1";
//        args[3] = "card-2";
//
        args = new String[2];
        args[0] = "receiptInput.txt";
        args[1] = "discountCards.txt";


        ProductFactory productFactory;
        Data data= new DataFromClass();;
        Basket basket = new Basket();
        ReceiptInput input;
        DiscountBase discountBase = new DiscountCardBaseFromFile();
        Discount discount;


            int receiptInput = 0;
            int dataFromFile = 0;
            int dataDiscountCards = 0;
            String nameOfFileReceiptInput = "";
            String nameOfFileData = "";
            String nameOfDiscountCardFile = "";

        if (args.length > 0) {
            for (String s : args) {
                if (s.toLowerCase().contains("receiptinput")) {
                    receiptInput = 1;
                    nameOfFileReceiptInput = s;
                }
//                if (s.toLowerCase().contains("data")) {
//                    dataFromFile = 1;
//                    nameOfFileData = s;
//                }
                if (s.toLowerCase().contains("discountcards")) {
                    dataDiscountCards = 1;
                    nameOfDiscountCardFile = s;
                }

            }
            System.out.println("receiptInput - " + receiptInput + "\n dataFromFile - " + dataFromFile);

            if (receiptInput == 1) {
                input = new ReceiptInputFromFile();
                args = input.input(nameOfFileReceiptInput);
            }
            if (dataFromFile == 1) {
                data = new DataFromFile(nameOfFileData);
            }

//            if(dataDiscountCards ==1) {
//                discount = discountBase.readingFromFile(nameOfDiscountCardFile);
//            }



        }


        discount = discountBase.readingFromFile(nameOfDiscountCardFile);
       // discount = data.discountData();
        productFactory = data.productsData();

        for (int i = 0; i < args.length; i++) {

            if (args[i] != null && !args[i].toLowerCase().contains("card")) {
                Integer idOfProduct = Integer.valueOf(args[i].substring(0, args[i].indexOf("-")));
                Integer amountOfProduct = Integer.valueOf(args[i].substring(args[i].indexOf("-") + 1));

                productRecognition(productFactory, basket, idOfProduct, amountOfProduct);

            } else {
                Integer numberOfCard = Integer.valueOf(args[i].substring(5));
                //System.out.println("card we have " + args[i]);
                basket = cardRecognition(basket,discount,numberOfCard);

            }
        }


        Receipt receipt1 = new Receipt.ReceiptBuilder(basket)
                .setIsPrintInConsole(true)
                .setIsSaveInFile(false)
                .build();





    }

    static void productRecognition (ProductFactory productFactory,Basket basket,Integer idOfProduct, Integer amountOfProduct ){


        try {
            // System.out.println("product we have " + args[i]);

            // System.out.println("id of product is " + idOfProduct);

            // System.out.println("amount of product is " + amountOfProduct);
            if (productFactory.getProductMap().containsKey(idOfProduct)) {
                Product product = productFactory.getProductMap().get(idOfProduct);
                //  System.out.println("product start amount in map " + product.getAmountOfProduct());
                if (product.getAmountOfProduct() == 0) {

                    product.setAmountOfProduct(amountOfProduct);
                } else {
                    product.setAmountOfProduct(product.getAmountOfProduct() + amountOfProduct);
                }
                //   System.out.println("pr new amount in map " + product.getAmountOfProduct());

                basket.addProduct(product);
                // System.out.println("was added product  " + product);
            } else {
                System.out.println("there are no such product ");
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            System.out.println("incorrect  product");
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