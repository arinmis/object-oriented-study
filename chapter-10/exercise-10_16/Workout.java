import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 *  Introduction to Java Programming - 10.16
 *
 *  @author Mustafa Arınmış
 *  @since 30.06.2020
 *
 *   (Divisible by 2 or 3 ) Find the first ten numbers with 50 decimal digits that are
 *   divisible by 2 or 3 .
 * */

public class Workout{
    public static void main(String[] args) {

        BigInteger divisible = new BigInteger("10");
        divisible = divisible.pow(49);
        ArrayList<BigInteger> numArrayList = new ArrayList<BigInteger>();

        while(numArrayList.size() < 10) {
            if(divisible.remainder(BigInteger.TWO).equals(BigInteger.ZERO))
                numArrayList.add(divisible);
            else if(divisible.remainder(new BigInteger("3")).equals(BigInteger.ZERO))
                numArrayList.add(divisible);

             divisible = divisible.add(BigInteger.ONE);
             System.out.println(divisible);

        }

        System.out.println("Divisible by 2 or 3:\n" + numArrayList);

    }
}