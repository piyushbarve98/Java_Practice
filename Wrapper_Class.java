
import java.util.* ;
class Wrapper_Class {
    
    public static void main(String[] args){
        Scanner inp = new Scanner(System.in);
        String var2 = inp.next();
        char max = '0';
        for(int i = 0; i<var2.length() ; i++){
            if(var2.charAt(i)>max) max = var2.charAt(i);
        }
        System.out.println(max);
    }
}