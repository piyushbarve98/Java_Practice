
public class Array_Objects {
    
    public static void main(String[] args){
        Food food1 = new Food("pizza");
        Food food2 = new Food("rice");
        Food food3 = new Food("burger");
        
        Food[] foodStore = {food1,food2,food3};
        
        for(int i =0; i<3 ; i++) System.out.println(foodStore[i]);
    }
    
}

class Food {
    
    String name;
    Food(String name){
        this.name = name;
    }
    
    public String toString(){
        return name;
    }
}