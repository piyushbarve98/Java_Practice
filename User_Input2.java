
import java.util.Scanner;

class User_Input2 {
    public static void main(String[] args){
        Scanner obj = new Scanner(System.in);
        
        System.out.println("Enter your username");
        String uname = obj.nextLine();
        
        System.out.println("Enter your Age");
        int age = obj.nextInt();
        
        System.out.println("Enter your Salary in lack per annum");
        double salary = obj.nextDouble();
        
        System.out.println("Username: " + uname + " Age: " + age + " Salary: " + salary + " LPA");
        
        
    }
}