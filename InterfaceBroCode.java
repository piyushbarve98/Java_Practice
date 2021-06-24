
public class InterfaceBroCode{
    
    public static void main(String[] args){
        
        Rabbit r1 = new Rabbit();
        r1.flee();
        Tiger t1 = new Tiger();
        
        t1.attack();
        
        Fish f1 = new Fish();
        f1.flee();
        f1.attack();
    }
}

class Rabbit implements Prey{
    
    public void flee(){
        System.out.println("The rabbit fleed...");
    }
}

class Tiger implements Predators{
    
    @Override 
    public void attack(){
        System.out.println("The tiger has attacked it's prey.");
    }
}

class Fish implements Prey, Predators{
    
    public void flee(){
        System.out.println("The fish has fleed...");
    }
    
    public void attack(){
        System.out.println("The fish has attacked another fish.");
    }
}

interface Prey{
    
    public void flee();
}

interface Predators{
    
    public void attack();
}