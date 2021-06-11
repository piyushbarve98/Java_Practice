
public class Object_Passing{
    
    public static void main(String[] args){
        
        Car car1 = new Car("BMW");
        Car car2 = new Car("Tesla");
        
        Garage garage = new Garage();
        garage.park(car1);
        garage.park(car2);
    }
    
}

class Car{
    
    String name ;
    Car(String name){
        this.name = name;
    }
}

class Garage {
    
    public void park(Car car){
        System.out.println(car.name + " is parked Safely in garage");
    }
}