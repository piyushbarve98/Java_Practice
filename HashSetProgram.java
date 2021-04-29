import java.util.HashSet;

class HashSetProgram {
    
    public static void main(String[] args){
        
        HashSet<Integer> id = new HashSet<Integer>();
        
        id.add(233);
        id.add(467);
        id.add(233);
        
        for(int i = 0 ; i<=1000 ; i++){ 
            if(id.contains(i)) System.out.println(i + " is in id");
        }
        
    }
}