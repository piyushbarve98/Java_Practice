
import java.util.HashMap;
import java.util.Scanner;
public class JavaHashMap{
    
    public static void main(String[] args){
        
        int option= 3;
        String name;
        Integer points;
        HashMap<String, Integer> gamePoints = new HashMap<String, Integer>(); 
        
        Scanner sc = new Scanner(System.in);
        gamePoints.put("Piyush", 80);
        gamePoints.put("Yoshi", 85);
        gamePoints.put("Mark", 79);
        
        
        while(option!=0){
            
            System.out.println("0: Quit , 1: Add , 2: Delete , 3: Show List , 4: Show Points , 5: Delete Whole List");
            option = sc.nextInt();
            sc.nextLine();
            switch(option){
                case 1: 
                    System.out.println("Enter Name");
                    name = sc.nextLine();
                    System.out.println("Enter Points");
                    points = sc.nextInt();
                    
                    gamePoints.put(name, points);
                    break;
                
                case 2:
                    System.out.println("Enter name to delete");
                    name = sc.nextLine();
                    gamePoints.remove(name);
                    
                    break;
                
                case 3 :
                    for(String i : gamePoints.keySet()){
                        System.out.println(i + "\t" + ": " + gamePoints.get(i));
                    }
                    break;
                    
                case 4:
                    System.out.println("Enter name to show points");
                    name = sc.nextLine();
                    System.out.println("Points : " + gamePoints.get(name));
                    break;
                case 5 : 
                    gamePoints.clear();
                    System.out.println("List Deleted");
            }
            
            
        }
       
    }
}

