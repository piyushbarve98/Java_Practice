import java.util.ArrayList;

public class Java_2dArraylist{
    
    public static void main(String[] args){
        
        ArrayList<String> mobiles = new ArrayList<String>();
        mobiles.add("Mi 8");
        mobiles.add("Mi 9");
        mobiles.add("Mi 10");
        
        
        ArrayList<String> earphones = {"Mi rocks","Mi repels"};
        
        // earphones.add("Mi rocks");
        // earphones.add("Mi repels");
        
        ArrayList<ArrayList<String>> mi = new ArrayList<ArrayList<String>>();
        
        mi.add(mobiles);
        mi.add(earphones);
        
        // System.out.println(mi);
        
        for(int i = 0; i< mi.size() ; i++) {
            for(int j =0; j<mi.get(i).size() ; j++)
                System.out.println(mi.get(i).get(j));
        }
        
        
    }
}