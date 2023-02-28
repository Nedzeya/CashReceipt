package receipt;

import basket.Basket;
import basket.DiscountCardBasket;
import discount.Discount;
import product.Product;
import product.ProductFactory;

public class ReceiptInputFromConsole implements ReceiptInput{

    private String[] args;
    private ProductFactory productFactory;
    private Basket basket;
    private Discount discount;

    public ReceiptInputFromConsole() {
    }

    @Override
    public void input (String[] args, ProductFactory productFactory, Basket basket, Discount discount) {

        this.args = args;
        this.productFactory = productFactory;
        this.basket = basket;
        this.discount = discount;


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
                //System.out.println("card we have " + args[i]);
                try {
                    Integer numberOfCard = Integer.valueOf(args[i].substring(5));
                    //System.out.println("number of card is " + numberOfCard);
                    if (discount.getDiscountMap().containsKey(numberOfCard)) {
                        basket = new DiscountCardBasket(basket.getBasketMap(), numberOfCard);

                    }
                } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                    System.out.println("incorrect number of card");
                }

            }
        }
    }


}
