/**
 *  Programming Exercise 19.05
 *
 *  (Maximum element in an array) Implement the following method that returns the
 *  maximum element in an array.
 *
 *  public static <E extends Comparable<E>> E max(E[] list)
 *
 *  @author Mustafa Arinmis
 *  @since 31.12.2020
 * */

import java.util.Arrays;

public class Exercise19_05{
    public static void main(String[] args) {
        Integer[] numbers = new Integer[5];
        for (int i=0; i< numbers.length; i++)
            numbers[i] = (int)(Math.random() * 100)  + 1;

        System.out.println(Arrays.toString(numbers));
        System.out.println("Max element of an number array: " + max(numbers));

    }

    public static <E extends Comparable<E>> E max(E[] list) {
        E max = list[0];
        for(int i=1; i<list.length; i++) {
            if(list[i].compareTo(max) == 1)
                max = list[i];
        }
        return max;
    }
}
