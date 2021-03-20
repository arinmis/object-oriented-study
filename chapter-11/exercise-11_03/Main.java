import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


/**
 *
 *  Introduction to Java Programming - Programming Exercise 11.3
 *
 *  @author Mustafa Arinmis
 *  @since 22.08.2020
 *
 * */



public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();

        Scanner input = new Scanner(System.in);

        System.out.println("Enter sequence of number, press 0 to ending");

        int temp = 0;
        int step = 1;
        while (true) {
            System.out.println("Enter number " + step++ + ": ");
            temp = input.nextInt();
            if(temp == 0)
                break;
            else
                nums.add(temp);
        }

        System.out.println("Maximum number of sequence" + max(nums));
    }

    public static Integer max(ArrayList<Integer> list) {
        if( list.size() == 0)
            return null;

        int temp = list.get(0);

        for(int i=0; i<list.size(); i++) {
            temp = Math.max(temp, list.get(i));
        }

        return temp;
    }

}