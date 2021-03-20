/**
 *  Programming Exercise 13.19
 *
 *  (Convert decimals to fractions) Write a program that prompts the user to enter
 *  a decimal number and displays the number in a fraction.
 *
 *  @author Mustafa Arinmis
 *  @since 29.12.2020
 * */

import java.math.BigInteger;
import java.util.Scanner;

public class Exercise13_19{
    public static void main(String[] args) {

        // prompt decimal
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        String decimal = input.next();

        //convert decimal to rational
        Rational result = getRational(decimal);

        //print result
        System.out.println(result);
    }

    public static Rational getRational(String decimal) {
        //here is the pattern:
        // 3.25 = 3.0 + 0.25 --> 3 --> 3/1
        // 0.25 * 10 = 2.5   --> 2 --> 2/10
        // 0.5 * 10 = 5.0    --> 5 --> 5/100
        // 0.0 * 10 = 0.0
        // when the decimal part is equal to 0, we need to stop
        //result will be sum of all rational numbers --> 3/1 + 2/10 + 5/100

        String[] decimalParts = decimal.split("[.]");

        BigInteger tempNumerator = getDecNumerator(decimalParts[0]);
        BigInteger tempDenominator = new BigInteger("1");

        Rational result = new Rational(tempNumerator, tempDenominator);

        for(int i=0; i<decimalParts[1].length(); i++) {
            tempDenominator = tempDenominator.multiply(BigInteger.TEN); //multiply by 10 in each iteration
            String digit = decimalParts[1].substring(i, i+1); // extract digit
            tempNumerator = new BigInteger(digit); //create numerator
            result = result.add(new Rational(tempNumerator, tempDenominator));
        }

        return result;
    }

    /* return numerator with it's sign */
    public static BigInteger getDecNumerator(String number) {
        BigInteger result = new BigInteger(number);
        if(number.charAt(0) == '-')
            result.negate();
        return result;

    }
}
