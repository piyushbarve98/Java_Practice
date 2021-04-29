
import java.util.HashMap;
import java.util.Scanner;
class HashMapProgram {
    
    public static void main(String[] args){
        HashMap<String, String> Grades = new HashMap<String, String>();
        
        Grades.put("Raven","A");
        Grades.put("Tom","B");
        Grades.put("Vivian", "A+");
        
        for(String i : Grades.keySet()){
            System.out.println(i + "got an " + Grades.get(i));
        }
        
        HashMap<Integer, String> Entry = new HashMap<Integer, String>();
        Scanner inp = new Scanner(System.in);
        int choice = 1;
        int keyval = 1;
        while(choice ! == 2){
            System.out.println("Enter choice: ");
            choice = inp.nextInt();
            switch(choice){
                
                case 0:
                    System.out.println("The Entries are: ");
                    for(int i : Entry.keySet()) System.out.println(i + ": " + Entry.get(i));
                    break;
                    
                
                case 1:
                    System.out.println("Enter New Entry: (NAME)");
                    String name = inp.next();
                    Entry.put(keyval, name);
                    keyval += 1;
                    break;
                  
                case 2:
                    System.out.println("The program ends here...");
                    
                
                    
            }
            
        
            
        }
    }
    
}