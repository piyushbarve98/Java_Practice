import java.util.regex.*;
import java.util.Scanner;

class Regex_Practice1{
    
    public static void main(String[] args){
        
        System.out.println("Write the word you want to find in the String/paragraph");
        
        Scanner sc = new Scanner(System.in);
        
        int count = 0;
        String word = sc.nextLine().trim();
        System.out.println("Now paste your paragraph and hit enter");
        String para = sc.nextLine();
        Pattern p = Pattern.compile(word, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(para);
        
        while(m.find()){
            count++;
            System.out.println("The word is present at index: " + m.start());
        }
        
        System.out.println((count !=0)? word + " is present: " + count + " times" : word + " is not present in paragraph");
        
    }
}