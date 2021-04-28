

class Animals {

    
    
    void sound(String s){
        System.out.println( s + " makes a sound");
    }

}

class Dogs extends Animals {
    
    
   
}

class Cat extends Animals {
    
    
}

class Polimorphism {

    public static void main(String[] args){
        Cat a1 = new Cat();
        a1.sound("cat");
        }
}