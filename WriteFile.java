
import java.io.FileWriter;
import java.io.IOException;

class WriteFile {
    public static void main(String[] args){
        
        try{
        FileWriter writer = new FileWriter("myfile.txt");
        writer.write("We have written in this text file through the java program WriteFile.java");
        writer.close();
        System.out.println("Writing to the file completed succesfully");
        }catch(IOException e){
            System.out.println("Some Error Occurred...");
            e.printStackTrace();
        }
    }
}