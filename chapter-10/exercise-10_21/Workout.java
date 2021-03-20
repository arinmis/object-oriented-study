import java.math.BigInteger;

/**
 *
 *  Introduction to Java Programming - 10.21
 *
 * (Divisible by 5 or 6 ) Find the first ten numbers greater than Long.MAX_VALUE
 * that are divisible by 5 or 6 .
 *
 *  @author Mustafa Arinmis
 *  @since 04.08.2020
 *
 * */



public class Workout {
    public static void main(String[] args) {

        BigInteger number = new BigInteger(Long.MAX_VALUE + "");
        number = number.add(BigInteger.ONE);

        int count = 0;
        while(count < 10) {

            if( number.remainder(new BigInteger(5 + "")).equals(BigInteger.ZERO) ||
                    number.remainder(new BigInteger(6 + "")).equals(BigInteger.ZERO)) {
                System.out.println(number);
                count++;
            }

            number = number.add(BigInteger.ONE);
        }

    }
}