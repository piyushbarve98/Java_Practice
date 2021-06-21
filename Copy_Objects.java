
public class Copy_Objects{
    
    public static void main(String[] args){
        
        Mobile m1 = new Mobile("Samsung", 4500, true);
        Mobile m2 = new Mobile("Redmi",3800,true);
        
        m2.copy(m1);
        
        System.out.println(m1 + " " + m2);
        System.out.println(m2.name + " " + m2.battery + " " + m2.isAndroid);
        
    }
}

class Mobile{
    
    String name;
    int battery;
    boolean isAndroid;
    Mobile(String name, int battery, boolean isAndroid){
        
        this.name = name;
        this.battery = battery;
        this.isAndroid = isAndroid;
    }
    
    public void copy(Mobile m){
        this.name = m.name;
        this.battery = m.battery;
        this.isAndroid = m.isAndroid;
    }
    
}