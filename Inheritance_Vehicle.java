

class Vehicle{
    int speed;
    
    void go(){
        System.out.println("Vehicle is moving...");
    }
    
    void stop(){
        System.out.println("Vehicle has stopped moving...");
    }
    
}

class Car extends Vehicle{
    int wheel;
    int doors;
}

class Bicycle extends Vehicle{
    
    int wheel;
    int pedals;
}

public class Inheritance_Vehicle{
    
    public static void main(String[] args){
        
        Bicycle bike1 = new Bicycle();
        bike1.go();
        Car car1 = new Car();
        System.out.println(car1.doors);
    }
}