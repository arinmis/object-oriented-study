/*Introduction to java Programming, Problem 9.10
 * @author Mustafa Arinmis
 * @since 05.14.2020
 * */

import java.util.Scanner;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    // delta = b^2 - 4*a*c
    public double getDiscriminat() {
        return b * b - 4 * a * c;
    }
    public String getRoot1() {
        if(this.getDiscriminat() < 0)
            return "The equations have no real root";
        else if(this.getDiscriminat() == 0)
                return "0";
        return "" + (-b + Math.sqrt(this.getDiscriminat())) / (2 * a);
    }

    public String getRoot2() {
        if(this.getDiscriminat() < 0)
            return "The equations have no real root";
        else if(this.getDiscriminat() == 0)
            return "0";
        return "" + (-b - Math.sqrt(this.getDiscriminat()) ) / (2 * a);
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
}

class Test {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a, b and c");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        QuadraticEquation eq = new QuadraticEquation(a, b, c);
        System.out.println("First root is: " + eq.getRoot1() +
                "\nSecond root is: " + eq.getRoot2());

    }
}
