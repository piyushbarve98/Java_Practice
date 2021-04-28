import java.util.Scanner;

class User_input {

    public static void main(String[] args){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter your Name: ");
        String Name = myObj.nextLine();
        System.out.println("So your name is " + Name + " Perfect ...");
    }
}