import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 *  Introduction to Java Programming - 10.20
 *
 *  Estimation of euler number respect to this series 1 + 1/1! + 1/2! ..... 1/i!
 *
 *  @author Mustafa Arinmis
 *  @since 3.08.2020
 *
 * */

public class Euler {
    public static void main(String[] args) {
        for(int i=100; i<=1000; i = i+100) {
            System.out.println("Estimated e is: " + eulerEstiamte(i));
        }

    }

    public static BigDecimal eulerEstiamte(int element) {
        BigDecimal estimate = new BigDecimal("0");
        for(int i=0; i<element; i++) {
            estimate = estimate.add(BigDecimal.ONE.divide(fac(i)));
        }

        return estimate;
    }

    public static BigDecimal fac(int i) {
        if (i == 0)
            return BigDecimal.ONE;

        return new BigDecimal("i").multiply(new BigDecimal(fac(i-1) + ""));
    }
}
