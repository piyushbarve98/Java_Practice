
import java.util.Random;
public class Variable_Scope{

    public static void main(String[] args){

        Dice_Roll d = new Dice_Roll();

        System.out.println(d);
    }
}

class Dice_Roll{

    Random random;
    int number;
    Dice_Roll(){
        random = new Random();
        number = random.nextInt(6) + 1;

    }

    int roll(){
        return number;
    }


}