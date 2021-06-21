package package1;

import package2.*;
public class AccessModifiers{
    
    public static void main(String[] args){
        
        AccessModifiersC obj1 = new AccessModifiersC();
        
        System.out.println(obj1.msg2);
    }
}

class B{
    
}