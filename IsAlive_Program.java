
class IsAlive_Program extends Thread {
    
    public static int val = 0;
    
    public static void main(String[] args){
        
        IsAlive_Program myObj = new IsAlive_Program();
        System.out.println(myObj.val);
        
        myObj.start();
        
        while(myObj.isAlive()){
            System.out.println("Thread is running...");
        }
        System.out.println("Thread run completed...");
        System.out.println(myObj.val);
        val = val + 1;
        System.out.println("value after main increment");
        System.out.println(val);
    }
    
    public void run(){
        val = val + 1;
    }
}