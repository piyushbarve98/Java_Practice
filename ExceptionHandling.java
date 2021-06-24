
import java.util.Scanner;
import java.util.InputMismatchException;
public class ExceptionHandling{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        try{
        System.out.println("Enter the numbers: ");
        int x = sc.nextInt();
        int y = sc.nextInt();

        int z = x/y;
        System.out.println(z);
        } catch(ArithmeticException e){
            System.out.println("Arithmetic Error Occured: " + e);
        }
        catch(InputMismatchException e){
            System.out.println("Input Mismatch Error Occured: " + e);
        }
        finally{
            System.out.println("Program Terminated...");
        }
    }
}

