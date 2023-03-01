import basket.Basket;
import basket.DiscountCardBasket;
import discount.Discount;
import discount.DiscountCard;
import product.Product;
import product.ProductFactory;
import receipt.Receipt;
import receipt.ReceiptInput;
import receipt.ReceiptInputFromFile;


public class Main {
    public static void main(String[] args) {

        args = new String[4];
        args[0] = "3-100";
        args[1] = "3-1";
        args[2] = "card-5";
        args[3] = "5-2";

//        args = new String[1];
//        args[0] = "x.txt";


        Discount discount = new DiscountCard();
        discount.addDiscount(new DiscountCard(4, 1));
        discount.addDiscount(new DiscountCard(10, 2));


        ProductFactory productFactory = new ProductFactory();
        Product product1 = productFactory.createActionSixProduct(3, "hhh", 888);
        Product product2 = productFactory.createActionSixProduct(4, "hph", 98);
        Product product3 = productFactory.createSimpleProduct(5, "q", 978);
        Product product4 = productFactory.createSimpleProduct(6, "w", 9);


        Basket basket = new Basket();


        ReceiptInput input;
        if (args.length > 0 && args[0].toLowerCase().contains(".txt")) {
            input = new ReceiptInputFromFile();
            args = input.input(args);
        }


        for (int i = 0; i < args.length; i++) {

            if (args[i] != null && !args[i].toLowerCase().contains("card")) {
                Integer idOfProduct = Integer.valueOf(args[i].substring(0, args[i].indexOf("-")));
                Integer amountOfProduct = Integer.valueOf(args[i].substring(args[i].indexOf("-") + 1));

                try {
                    System.out.println("product we have " + args[i]);

                    // System.out.println("id of product is " + idOfProduct);

                    // System.out.println("amount of product is " + amountOfProduct);
                    if (productFactory.getProductMap().containsKey(idOfProduct)) {
                        Product product = productFactory.getProductMap().get(idOfProduct);
                        System.out.println("product start amount in map " + product.getAmountOfProduct());
                        if (product.getAmountOfProduct() == 0) {

                            product.setAmountOfProduct(amountOfProduct);
                        } else {
                            product.setAmountOfProduct(product.getAmountOfProduct() + amountOfProduct);
                        }
                        System.out.println("pr new amount in map " + product.getAmountOfProduct());

                        basket.addProduct(product);
                        // System.out.println("was added product  " + product);
                    } else {
                        System.out.println("there are no such product " + args[i]);
                    }
                } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                    System.out.println("incorrect  product");
                }


            } else {
                Integer numberOfCard = Integer.valueOf(args[i].substring(5));
                //System.out.println("card we have " + args[i]);
                try {

                    //System.out.println("number of card is " + numberOfCard);
                    if (discount.getDiscountMap().containsKey(numberOfCard)) {
                        basket = new DiscountCardBasket(basket.getBasketMap(), numberOfCard);

                    }
                } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                    System.out.println("incorrect number of card");
                }

            }
        }


        Receipt receipt1 = new Receipt.ReceiptBuilder(basket)
                .setIsPrintInConsole(true)
                .setIsSaveInFile(false)
                .build();


    }
}