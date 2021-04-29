import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
class ArrayListProgramm {
    
    public static void main(String[] args){
        
        ArrayList<String> names = new ArrayList<String>();
        System.out.println("First list of students are: ");
        names.add("Raven");
        names.add("Freddy");
        names.add("Steven");
        
        for(String i : names){
            System.out.println(i);
        }
        
        String thirdName = names.get(2);
        System.out.println("Third name is: ");
        System.out.println(thirdName);
        
        names.remove(1);
        System.out.println(names.get(1));
        
        
        System.out.println("The size of array is : " + names.size());
        
        names.set(1,"new name");
        
          for(String i : names){
            System.out.println(i);
        }
        
        names.clear();
        System.out.println("Now the size after clearing is: " + names.size());
        
        ArrayList<Integer> marks = new ArrayList<Integer>();
        marks.add(45);
        marks.add(78);
        marks.add(93);
        marks.add(78);
        marks.add(67);
        
        Collections.sort(marks);
        for(int i : marks) System.out.println(i);
        
        
        ArrayList<Integer> values = new ArrayList<Integer>();
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter five values");
        for(int i = 0; i<5; i++){
            int val = inp.nextInt();
            values.add(val);
        }
        System.out.println("We have stored the values");
        System.out.println("The values are: ");
        for( int i : values){
            System.out.println(i);
        }
        
        
    }
}