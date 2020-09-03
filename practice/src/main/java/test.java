import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    public static void main(String[] args) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = "1597372766260";
        long lt = new Long(s);
        Date date = new Date(lt);
        String a = simpleDateFormat.format(date);

        System.out.println(a);
    }
}
