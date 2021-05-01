
class Threads_Program extends Thread {
    
    public void run(){
        System.out.println("another text from run method");
        System.out.println("print from run method");
    }
    public static void main(String[] args){
        
        Threads_Program myObj = new Threads_Program();
        myObj.start();
        System.out.println("This is from main function");
    }
}