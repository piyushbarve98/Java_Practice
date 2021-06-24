
import java.util.Scanner;
public class DynamicPolymorphism{
    
    public static void main(String[] args){
        
        Animal animal = new Animal();
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter Option: 1.for Dog 2.for Cat");
        int option= scan.nextInt();
        while(option!=0){
        
        
        
        
        if(option==1) animal = new Dog();
        else if(option==2) animal = new Cat();
       
        animal.speak();
        option= scan.nextInt();
        }
        
        
        
            
    }
}

class Animal{
    public void speak(){
        System.out.println("The Animal Speaks...");
    }
}

class Dog extends Animal{
    public void speak(){
     System.out.println("The Dog barks...");
}
}

class Cat extends Animal{
    public void speak(){
     System.out.println("The cat Says meow...");
    }
}