import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    public static boolean isValid(String email){
        Pattern pattern=Pattern.compile("^[a-zA-Z]+[a-zA-Z0-9.]*[a-zA-Z0-9]@[a-zA-Z0-9]*\\.[a-zA-Z]{2,}$");
        Matcher matcher=pattern.matcher(email);
        return matcher.matches();
    }
}
