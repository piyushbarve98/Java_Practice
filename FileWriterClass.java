
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class FileWriterClass{
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        try{
        FileWriter writer = new FileWriter("File.txt");
        
        // writer.write("This is written thorugh write");
        
        System.out.println("Enter the text: ");
        String text = sc.nextLine();
        writer.append(text);
        writer.close();
        } catch(IOException e){
            e.printStackTrace();
        }
        
    }
}