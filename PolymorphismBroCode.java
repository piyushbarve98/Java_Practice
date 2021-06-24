
public class PolymorphismBroCode{
    
    public static void main(String[] args){
        
        
        Car c1 = new Car();
        Bicycle b1 = new Bicycle();
        Boat boat = new Boat();
        
        Vehicle[] arr = {c1,b1,boat};
        
        for( Vehicle x : arr) x.go();
        
    }
}

class Vehicle {
    public void go(){
        System.out.println("Vehicle has started running...");
    }
    
}

class Car extends Vehicle{
    public void go(){
        System.out.println("Car has started running...");
    }
}

class Bicycle extends Vehicle{
     public void go(){
        System.out.println("Bicycle has started running...");
    }
}

class Boat extends Vehicle{
     public void go(){
        System.out.println("Boat has started running...");
    }
}