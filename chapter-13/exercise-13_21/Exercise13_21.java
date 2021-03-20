/**
 *  Programming Exercise 13.20
 *
 *  (Algebra: vertex form equations) The equation of a parabola can be expressed
 *  in either standard form (y = ax 2 + bx + c) or vertex form (y = a(x - h) 2 + k).
 *  Write a program that prompts the user to enter a, b, and c as integers in standard
 *  form and displays h and k in the vertex form. Here are some sample runs.
 *
 *  @author Mustafa Arinmis
 *  @since 29.12.2020
 * */

import java.util.Scanner;


public class Exercise13_21{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a, b, c: ");
        long a = input.nextLong();
        long b = input.nextLong();
        long c = input.nextLong();

        Rational h = getH(a, b);
        Rational k = getK(a, b, c);

        System.out.println("h is " + h + " k is " + k );

    }

    /* h can be found by this formula --> h = –b/2a */
    public static Rational getH(long a, long b) {
       return new Rational(-b, 1).divide(new Rational(2 * a, 1));
    }

    /* h can be found by this formula --> k = (4ac – b^2) / 4a */
    public static Rational  getK(long a, long b, long c) {
       return new Rational(4 * a * c - (long)Math.pow(b, 2) , 1).divide(new Rational(4 * a, 1));
    }

}
