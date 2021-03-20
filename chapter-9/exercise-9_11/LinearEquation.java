/*Introduction to java Programming, Problem 9.11
 * @author Mustafa Arinmis
 * @since 05.14.2020
 * */

import java.util.Scanner;

public class LinearEquation {
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;

    public LinearEquation(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    public boolean isSolvable() {
        if(a*d == a*b)
            return false;
        return true;
    }

    public String getX() {
        if(this.isSolvable()) {
            return String.valueOf((e * d - b * f) / (a * d - b * c));
        }
        else
            return "The equation has no solution.";

    }

    public String getY() {
        if(this.isSolvable()) {
            return String.valueOf((a * f - e * c) / (a * d - b * c));
        }
        else
            return "The equation has no solution.";

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

    public double getD() {
        return d;
    }

    public double getE() {
        return e;
    }

    public double getF() {
        return f;
    }

}

class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter value of  a: ");
        double a = input.nextDouble();
        System.out.println("Enter value of  b: ");
        double b = input.nextDouble();
        System.out.println("Enter value of  c: ");
        double c = input.nextDouble();
        System.out.println("Enter value of  d: ");
        double d = input.nextDouble();
        System.out.println("Enter value of  e: ");
        double e = input.nextDouble();
        System.out.println("Enter value of  f: ");
        double f = input.nextDouble();

        LinearEquation linEq = new LinearEquation(a, b, c, d, e, f);

        System.out.println("Solution of x: " +linEq.getX() +
                            "\nSolution of y:" + linEq.getY());
    }
}
