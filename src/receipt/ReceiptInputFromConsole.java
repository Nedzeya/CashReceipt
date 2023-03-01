package receipt;

import basket.Basket;
import basket.DiscountCardBasket;
import discount.Discount;
import product.Product;
import product.ProductFactory;

public class ReceiptInputFromConsole implements ReceiptInput {

    private String[] args;
    private ProductFactory productFactory;
    private Basket basket = new Basket();
    private Discount discount;
    private Integer numberOfCard;

    public ReceiptInputFromConsole() {
    }


    private boolean isItDiscountBasket() {
        for (String s : args) {
            if (s.toLowerCase().contains("card")) {
                try {
                    Integer numberOfCard = Integer.valueOf(s.substring(5));

                    if (discount.getDiscountMap().containsKey(numberOfCard)) {
                        return true;

                    } else {
                        return false;
                    }
                } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                    System.out.println("incorrect number of card");
                }

            }
            return false;
        }

        return true;
    }

    @Override
    public void input(String[] args, ProductFactory productFactory, Discount discount) {

        this.args = args;
        this.productFactory = productFactory;
        this.discount = discount;

        if (isItDiscountBasket()){
            basket = new DiscountCardBasket(basket.getBasketMap(),numberOfCard);
        } else{
            basket = new Basket();
        }


        for (int i = 0; i < args.length; i++) {

            if (args[i] != null && !args[i].toLowerCase().contains("card")) {

                try {
                    // System.out.println("product we have " + args[i]);
                    Integer idOfProduct = Integer.valueOf(args[i].substring(0, args[i].indexOf("-")));
                    // System.out.println("id of product is " + idOfProduct);
                    Integer amountOfProduct = Integer.valueOf(args[i].substring(args[i].indexOf("-") + 1));
                    // System.out.println("amount of product is " + amountOfProduct);
                    if (productFactory.getProductMap().containsKey(idOfProduct)) {
                        Product product = productFactory.getProductMap().get(idOfProduct);
                        product.setAmountOfProduct(amountOfProduct);
                        basket.addProduct(product);
                        // System.out.println("was added product  " + product);
                    } else {
                        System.out.println("there are no such product " + args[i]);
                    }
                } catch (NumberFormatException |StringIndexOutOfBoundsException e) {
                    System.out.println("incorrect  product");
                }


            } else {
                    numberOfCard = Integer.valueOf(args[i].substring(5));
            }
        }
    }

    public Basket getBasket() {
        return basket;
    }
}
