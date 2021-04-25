public class Test {
    public static void main(String[] args){
        SecondTest p1 = new SecondTest();
        p1.greetings("Raven");
        p1.fullname("Raven", "Clark");
        String voteVar = (p1.canVote(20))? "Yes": "No";
        System.out.println(voteVar);
        String taxPayVar = (p1.taxPay(0))?"Yes pay tax": "No don't pay tax";
        System.out.println(taxPayVar);
    }
}