import java.util.HashMap;
import java.util.Map;

public interface Discount {

    double getPercentsOfDiscount ();
    int getNumberOfDiscount ();

    String getNameOfDiscount ();
    Map<Integer,Discount> discountMap = new HashMap<>();

   default void addDiscount (Discount discount) {
       discountMap.putIfAbsent(discount.getNumberOfDiscount(), discount);
   }



}
