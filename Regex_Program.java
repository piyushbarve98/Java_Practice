
import java.util.regex.* ;
class Regex_Program {
    
    public static void main(String[] args){
        
        Pattern pattern = Pattern.compile("[^abc]");
        Matcher matcher = pattern.matcher("re");
        if(matcher.find()) System.out.println("match found");
        else System.out.println("match not found");
    }
}