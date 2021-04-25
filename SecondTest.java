public class SecondTest {
    
    public void greetings(String name){
        System.out.println("Hello and welcome " + name);
    }
    
    public void fullname(String fname , String lname){
        System.out.println("Your Full name is: " + fname + " " + lname);
    }
    
    public boolean canVote(int age){
        return (age>18);
    }
    
    public boolean taxPay(int annualIncome){
        return (annualIncome> 800000);
    }
}