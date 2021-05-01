
import java.io.File;
import java.io.IOException;

class Create_File {

    public static void main(String[] args){

        try{
            File myFile = new File("File.text");
            if(myFile.createNewFile()){
                System.out.println("File created successfully: " + myFile.getName() );
            }
            else{
                System.out.println("File exists already");
            }
        } catch (IOException e){
            System.out.println("An error ocurred");
        }
    }
}