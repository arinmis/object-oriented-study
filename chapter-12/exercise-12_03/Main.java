import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 *  Introduction to Java Programming - Programming Exercise 12.3
 *
 *  @author Mustafa Arinmis
 *  @since 04.11.2020
 *
 * */

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] nums = new int[100];

        for(int i=0; i<100; i++)
            nums[i] = (int)(Math.random() * 1000) + 1;

        System.out.println("Enter desired array index: ");
        int index = input.nextInt();

        try {
            System.out.println(nums[index]);
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Out of Bounds");
        }


     }
}
