/**
 *  Programming Exercise 13.16
 *
 *  (Create a rational-number calculator) Write a program similar to Listing 7.9,
 * Calculator.java. Instead of using integers, use rationals, as shown in Figure 13.10a.
 * You will need to use the split method in the String class, introduced in
 * Section 10.10.3, Replacing and Splitting Strings, to retrieve the numerator string and
 * denominator string, and convert strings into integers using the Integer.parseInt
 * method.
 *
 *  @author Mustafa Arinmis
 *  @since 24.12.2020
 * */

import java.math.BigDecimal;
import java.math.BigInteger;

public class Exercise13_16{
    public static void main(String[] args) {
        // Check number of strings passed
        if (args.length != 3) {
            System.out.println(
                    "Usage: java Calculator operand1 operator operand2");
            System.exit(0);
        }

        //create rational numbers
        Rational r1 = getRational(args[0]);
        Rational r2 = getRational(args[2]);

        //make operation
        Rational result = getResult(r1, r2, args[1]);

        // Display result
        System.out.println(args[0] + ' ' + args[1] + ' ' + args[2]
                + " = " + result);
    }

    public static Rational getResult(Rational r1, Rational r2, String operation) {
        switch (operation.charAt(0)) {
            case '+':
                return r1.add(r2);
            case '-':
                return r1.subtract(r2);
            case '*':
                return r1.multiply(r2);
            case '/':
                return r1.divide(r2);
            default:
                return null;
        }
    }

    public static Rational getRational(String string) {
        String[] nums = string.split("/");
        return new Rational(new BigInteger(nums[0]), new BigInteger(nums[1]));
    }

}
