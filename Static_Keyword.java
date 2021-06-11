
public class Static_Keyword{
    
    public static void main(String[] args){
        
        Friend friend1 = new Friend("Mike");
        Friend friend2 = new Friend("Ryu");
        
        // System.out.println(Friend.no_of_friends);
        Friend.printFriends();
        
        
    }
}

class Friend{
    
    String name; 
    static int no_of_friends;
    Friend(String name){
        this.name = name ;
        no_of_friends++;
    }
    
    static void printFriends(){
        System.out.println(no_of_friends);
    }
}