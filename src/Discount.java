import java.util.HashMap;
import java.util.Map;

public interface Discount {
    double getPercentsOfDiscount ();
    int getNumberOfDiscount ();

    String getNameOfDiscount ();
    Map<Integer,Discount> discountMap = new HashMap<>();


}
