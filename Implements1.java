interface One {
    
    public void method1();
}

interface Two {
    
    public void method2();
}

class Demo implements One , Two {
    public void method1(){
        System.out.println("It is method1");
    }
    
    public void method2(){
        System.out.println("It is method2");
    }
}

class Implements1 {
    
    public static void main(String[] args){
        Demo myobj = new Demo();
        myobj.method1();
        myobj.method2();
        
    }
}