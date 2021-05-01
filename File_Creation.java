
import java.io.* ;
class File_Creation {
    
    public static void main(String[] args){
        
        File myObj = new File("myfile.txt");
        
        try{
        if(myObj.createNewFile()){
            System.out.println("File is created successfully " + myObj.getName());
            
        }
        
        else{
            System.out.println("File already Exists");
        }
        } catch(IOException e){
            System.out.println("An error ocurred");
            e.printStackTrace();
        }
        
    }
}