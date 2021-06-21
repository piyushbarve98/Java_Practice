
public class Java_Encapsulation{
    
    public static void main(String[] args){
        
        Car car1 = new Car("tesla","red st", 2018);
        
        System.out.println(car1.getMake());
        
        car1.setMake("ford");
        System.out.println(car1.getMake());
        
    }
}

class Car{
    
    private String make;
    private String model;
    private int year;
    
    Car(String make , String model , int year){
        this.make = make;
        this.model = model ;
        this.year = year;
    }
    
    public String getMake(){
        return make;
    }
    
    public void setMake(String make){
        this.make = make;
    }
}