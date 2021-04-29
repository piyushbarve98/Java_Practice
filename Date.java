import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
class Date {
    
    public static void main(String[] args){
        LocalDateTime obj = LocalDateTime.now();
        
        System.out.println("Date and time before formatting");
        System.out.println(obj);
        
        DateTimeFormatter myformatobj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        
        String dateTime = obj.format(myformatobj);
        
        System.out.println("Date and Time after formatting");
        System.out.println(dateTime);
        
        
    }
}

