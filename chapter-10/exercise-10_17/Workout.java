import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 *  Introduction to Java Programming - 10.17
 * (Square numbers) Find the first ten square numbers that are greater than
 * Long.MAX_VALUE . A square number is a number in the form of n 2 . For exam-
 * ple, 4, 9, and 16 are square numbers. Find an efficient approach to run your
 * program fast.
 *
 *  @author Mustafa Arınmış
 *  @since 30.06.2020
 *
 
 * */

public class Workout{
    public static void main(String[] args) {
        BigInteger initial = new  BigInteger(Long.MAX_VALUE + "");
        // sqrt() return less or equal integer of square root
        initial = initial.sqrt();
        initial = initial.add(BigInteger.ONE);
        System.out.println("the first ten square numbers that are greater than " +  Long.MAX_VALUE);

        for(int i=0; i<10; i++) {
            System.out.println(initial.pow(2));
            initial = initial.add(BigInteger.ONE);
        }

    }
}