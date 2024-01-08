import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class number {
    public static Boolean numberValid(String number) {
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(number);
        Boolean eminem =false;
        if (matcher.find()){
            eminem=true;
        }
        return eminem;
    }
}
