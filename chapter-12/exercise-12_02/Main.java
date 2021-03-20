import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 *  Introduction to Java Programming - Programming Exercise 12.2
 *
 *  @author Mustafa Arinmis
 *  @since 04.11.2020
 *
 * */

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num1 = -1;
        int num2 = -1;

        try {
            num1 = input.nextInt();
            num2 = input.nextInt();
        }
        catch(InputMismatchException ex) {
            System.out.println("Please enter integer values.");
            System.exit(0);
        }

        System.out.println(num1 + num2);
    }
}
