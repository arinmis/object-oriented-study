/**
 *  Programming Exercise 13.20
 *
 *  (Algebra: solve quadratic equations) Rewrite Programming Exercise 3.1 to obtain
 *  imaginary roots if the determinant is less than 0 using the Complex class in
 *  Programming Exercise 13.17.
 *
 *  @author Mustafa Arinmis
 *  @since 29.12.2020
 * */

import java.text.DecimalFormat;
import java.util.Scanner;


public class Exercise13_20{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a, b, c: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();

        //delta holds discriminant
        double delta = getDiscriminant(a, b, c);

        if(delta > 0) {
            System.out.println("The equation has two real roots " + getRoot1(a, b, delta)
                    + " and " + getRoot2(a, b, delta));
        }
        else if(delta == 0) {
            System.out.println("The equation has only one real roots " + getRoot1(a, b, delta));
        }else{
            // when discriminant(delta) is negative there are two root:
            // (-b/2a) + (sqrt(-delta) / 2a) * i and (-b/2a) - (sqrt(-delta) / 2a) * i
            // NOTE: i = sqrt(-1)
            Complex root1 = getComplexRoot1(a, b, delta);
            Complex root2 = getComplexRoot2(a, b, delta);
            System.out.println("There are two imaginary root: " + root1 + " and " + root2);
        }

    }

    public static double getRoot1(double a, double b, double delta) {
        return formatDecimal((-b + Math.sqrt(delta)) / 2 * a);
    }

    public static double getRoot2(double a, double b, double delta) {
        return formatDecimal((-b - Math.sqrt(delta)) / 2 * a );
    }


    public static double getDiscriminant(double a, double b, double c) {
        return formatDecimal(Math.pow(b, 2) - 4 * a * c);
    }

    public static Complex getComplexRoot1(double a, double b, double delta) {
        double real = -b/2*a;
        double imaginary = Math.sqrt(-delta) / 2*a;

        //formatting numbers
        real = formatDecimal(real);
        imaginary = formatDecimal(imaginary);

        return new Complex(real, imaginary);
    }

    public static Complex getComplexRoot2(double a, double b, double delta) {
        double real = -b/2*a;
        double imaginary = -(Math.sqrt(-delta) / 2*a);

        //formatting numbers
        real = formatDecimal(real);
        imaginary = formatDecimal(imaginary);

        return new Complex(real, imaginary);
    }

    private static double formatDecimal(double number) {
        /*return formatted double that only include 4 digit after the decimal point*/
        return Double.valueOf(new DecimalFormat(".######").format(number));
    }

}
