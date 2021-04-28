abstract class Animal {
    
    public abstract void speak ();
    
    public void sleep(){
        System.out.println("It is sleeping");
    }
}

class Dolphin extends Animal {
    
    public void speak (){
        System.out.println("Makes a sound...");
    }
    
    public void swim(){
        System.out.println("The dolphin starts to swim...");
    }
}

class Abstraction {
    
    public static void main(String[] args){
        Dolphin d1 = new Dolphin();
        d1.sleep();
        d1.speak();
        d1.swim();
    }
}