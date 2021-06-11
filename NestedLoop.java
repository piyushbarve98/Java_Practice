
import java.util.Scanner;
public class NestedLoop{
    
    public static void main (String[] args){
        
        Scanner scan = new Scanner(System.in);
        
        // System.out.println("Enter the height and width of rectangle: ");
        
        // int h = scan.nextInt();
        // int w = scan.nextInt();
        
        // System.out.println("Enter symbol to fill in rectangle");
        // char c = scan.next().charAt(0);
        
        // for(int i =0; i<h ; i++){
            
        //     for(int j=0 ; j<w ; j++){
                
        //         System.out.print(c);
        //     }
        //     System.out.println();
        // }
        
        String[] arr = {"one", "two"};
        
        arr[0] = "123";
        arr[2] = "yu";
        
        for(String i : arr) System.out.println(i);
    }
}