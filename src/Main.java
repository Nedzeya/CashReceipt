import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {


        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String time = "TIME: "+ timeFormat.format(new Date());
        System.out.println(time);
    }
}