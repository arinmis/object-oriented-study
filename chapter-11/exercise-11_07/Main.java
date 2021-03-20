import java.util.*;

/**
 *
 *  Introduction to Java Programming - Programming Exercise 11.7
 *
 *
 *  @author Mustafa Arinmis
 *  @since 22.08.2020
 *
 * */


public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(new Integer[] {1, 2, 3, 4, 5}));
        shuffle(nums);
        System.out.println(nums);
    }

    public static void shuffle(ArrayList<Integer> list) {
        Collections.shuffle(list);
    }
}

