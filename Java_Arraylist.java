import java.util.ArrayList;

public class Java_Arraylist{

    public static void main(String[] args){

        ArrayList<String> userId = new ArrayList<String>();

        userId.add("mikeId");
        userId.add("firstId");
        userId.set(1,"newId");

        // userId.clear(); make the list empty with zero elements
         if(userId.isEmpty()) System.out.println("List is Empty");
         else{
        // for(String i : userId){

        //      System.out.println(i);
        // } foreach loop
        
        for(int i = 0 ; i< userId.size() ; i++) System.out.println(userId.get(i));
        
        
         }
    }
}