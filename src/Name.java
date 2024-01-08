import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Name {
    public static Boolean nameValid(String name){
        Pattern pattern=Pattern.compile("[a-zA-Z]+");
        Matcher matcher=pattern.matcher(name);
        Boolean eminem=matcher.find();
        return eminem;
    }
}
