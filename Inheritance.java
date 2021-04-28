
class Phones {
    protected int batteryLife;
    protected int price;
    protected String companyName;

    Phones(int b, int p , String cn){
        batteryLife = b;
        price = p ;
        companyName = cn ;

    }

}

class AndroidPhones extends Phones {

    private int ram;
    private String processor;

    AndroidPhones(int b , int p , String cn , int r , String pro){
        super(b , p , cn );
        ram = r;
        processor = pro;
    }

    void display (){
        System.out.println("All Info. : " + "Battery Life: " + batteryLife + " Price: " + price + " Company Name: " + companyName + " Ram: " + ram + " Processor: " + processor );
    }

    boolean isGaming(){
        if(ram>3 && batteryLife > 2000 && price > 18000) return true;
    
        else return false;
    }


}

class Inheritance {

    public static void main(String[] args){

        AndroidPhones p1 = new AndroidPhones(4000, 30000, "Samsung m20", 4, "Exynos 720");
        p1.display();
        
        if(p1.isGaming()) System.out.println("Yes it is good for gaming");
        else System.out.println("Sorry not good for gaming chose another one");
        
    }
}