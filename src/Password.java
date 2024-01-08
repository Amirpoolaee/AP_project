import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {   public static int level(String email){
    int level=0;
    Pattern pattern1=Pattern.compile("[a-z]");
    Matcher matcher1= pattern1.matcher(email);
    if(matcher1.find()){
        level++;
    }
    Pattern pattern2=Pattern.compile("[A-Z]");
    Matcher matcher2=pattern2.matcher(email);
    if (matcher2.find()){
        level++;
    }
    Pattern pattern3=Pattern.compile("\\d");
    Matcher matcher3= pattern3.matcher(email);
    if (matcher3.find()){
        level++;
    }
    Pattern pattern4=Pattern.compile("[^a-zA-Z0-9]");
    Matcher matcher4=pattern4.matcher(email);
    if (matcher4.find()){
        level++;
    }
    if (email.length()>8){
        level++;
    }
    return level;
}
}
