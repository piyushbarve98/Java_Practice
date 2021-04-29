
import java.util.LinkedList;
class LinkedListProgram {
    
    public static void main(String[] args){
        
        LinkedList<String> language = new LinkedList<String>();
        language.add("English");
        language.addFirst("Hindi");
        language.addLast("Japanese");
        for( String i : language){
            System.out.println(i);
        }
    }
}