
class Enum_Program {
      
    enum Level {
            LOW ,
            MEDIUM,
            HIGH 
        } 
     
    public static void main(String[] args){
        Level myvar = Level.MEDIUM;
        for( Level var2 : Level.values()){
            System.out.println(var2);
        }
        
        String[] arr = {"one", "two", "three"};
        
        for(String var3 : arr){
            System.out.println(var3);
        }
    }   
    
}


