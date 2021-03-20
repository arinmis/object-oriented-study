/**
 *  Programming Exercise 13.18
 *
 *  (Use the Rational class) Write a program that computes the following summa-
 *  tion series using the Rational class:
 *
 *              1/2 + 2/3 + 3/4 + ... + 98/99 + 99/100
 *
 * You will discover that the output is incorrect because of integer overflow (too
 * large). To fix this problem, see Programming Exercise 13.15.
 *  @author Mustafa Arinmis
 *  @since 24.12.2020
 * */

import java.math.BigInteger;

public class Exercise13_18{
    public static void main(String[] args) {
        //since both numerator and denominator are too long, I used BigInteger version of Rational 
        Rational total = new Rational(new BigInteger("1"),new BigInteger("2"));
        for(int i=2; i<100; i++) {
           Rational temp = new Rational(new BigInteger(i + ""), new BigInteger((i + 1) + "") );
           total = total.add(temp);
        }
        System.out.println(total);
    }
}
