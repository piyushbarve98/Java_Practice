import java.util.Random;

public class RandomNum {

    public static void main(String[] args){

        Random random = new Random();

        int diceRollNum = random.nextInt(6) + 1;
        // int diceRollNum = (random.nextInt() % 6) + 1;
        // diceRollNum = (diceRollNum < 0) ? -diceRollNum : diceRollNum;

        System.out.println(diceRollNum);
    }
}