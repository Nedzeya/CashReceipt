import basket.Basket;
import basket.DiscountCardBasket;
import discount.Discount;
import discount.DiscountCard;
import product.Product;
import product.ProductFactory;
import receipt.Receipt;
import receipt.Input.ReceiptInput;
import receipt.Input.ReceiptInputFromFile;
import data.*;


public class Main {


    public static void main(String[] args) {

        args = new String[4];
        args[0] = "3-100";
        args[1] = "3-1";
        args[2] = "card-1";
        args[3] = "2-2";
//
//        args = new String[1];
//        args[0] = "x.txt";
        Discount discount;

        Data data = new DataFromClass();

        discount = data.discountData();


        ProductFactory productFactory = new ProductFactory();
        Product product1 = productFactory.createActionSixProduct(1, "Nicest Person", 888);
        Product product2 = productFactory.createActionSixProduct(2, "Best Looking", 98);
        Product product3 = productFactory.createSimpleProduct(3, "Best Face", 978);
        Product product4 = productFactory.createSimpleProduct(4, "Great Smile", 9);


        Basket basket = new Basket();


        ReceiptInput input;
        if (args.length > 0 && args[0].toLowerCase().contains(".txt")) {
            input = new ReceiptInputFromFile();
            args = input.input(args);
        }


        for (int i = 0; i < args.length; i++) {

            if (args[i] != null && !args[i].toLowerCase().contains("card")) {
                Integer  idOfProduct = Integer.valueOf(args[i].substring(0, args[i].indexOf("-")));
                Integer amountOfProduct = Integer.valueOf(args[i].substring(args[i].indexOf("-") + 1));

                    productRecognition(productFactory,basket,idOfProduct,amountOfProduct);

            } else {
                Integer numberOfCard = Integer.valueOf(args[i].substring(5));
                //System.out.println("card we have " + args[i]);
                basket = cardRecognition(basket,discount,numberOfCard);

            }
        }


        Receipt receipt1 = new Receipt.ReceiptBuilder(basket)
                .setIsPrintInConsole(true)
                .setIsSaveInFile(true)
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