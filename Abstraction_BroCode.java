
public class Abstraction_BroCode{

    public static void main(String[] args){

        Car car = new Car();

        car.msg();


    }
}

abstract class Vehicle{


    abstract void msg();
    abstract void go();
}

class Car extends Vehicle{

    @Override
    public void msg(){
        System.out.println("You have implemented the abstract method");
    }

}