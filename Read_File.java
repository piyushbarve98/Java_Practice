
import java.io.File ; 
import java.util.Scanner ;
import java.io.FileNotFoundException;

class Read_File {
    
    public static void main(String[] args){
        
        try{
        File myObj = new File("myfile.txt");
        Scanner scan = new Scanner(myObj);
        
        while(scan.hasNextLine()){
            String data = scan.nextLine();
            System.out.println(data);
        }
        scan.close();
        } catch(FileNotFoundException e){
            System.out.println("An Error ocurred");
            e.printStackTrace();
        }
    }
}