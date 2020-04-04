import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Nation {
    public static void main(String[] args) {
        Locale loc = Locale.ENGLISH;
        ResourceBundle res = ResourceBundle.getBundle("Message_en_US",loc);
        String val = res.getString("info");
        System.out.println(MessageFormat.format(val,"Mike",
                new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
    }
}
