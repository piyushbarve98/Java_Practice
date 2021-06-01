
class Hack_ForLoop {
    
     public static void main(String[] args) {
        int a=5, b=3 , n=5;
        double result =0;
        for(int j = 1 ; j <= n ; j++){
            
        for(int i =0; i< j ; i++){
            
            if(i==0){
                result = a + b;
            }
            else{
            result = result + (Math.pow(i,i-1) *b);
            }
            
            
        }
        if(j!=1) result = result + a;
        System.out.println(result);
        }
    }
}