import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 *  Introduction to Java Programming - Programming Exercise 11.12
 *
 *
 *  @author Mustafa Arinmis
 *  @since 22.08.2020
 *
 * */

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Double> list = new ArrayList<>();

        System.out.println("Enter 5 double: ");

        for(int i=0; i<5; i++) {
            list.add(input.nextDouble());
        }

        System.out.printf("Sum of all double eqauls: %.2f", sum(list));
    }

    public static double sum(ArrayList<Double> list) {
        double sum = 0;
        for(int i=0; i<list.size(); i++) {
            sum += list.get(i);
        }

        return sum;
    }
}