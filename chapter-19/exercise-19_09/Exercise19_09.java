/**
 *  Programming Exercise 19.09
 *
 *  (Sort ArrayList ) Write the following method that sorts an ArrayList :
 *
 *  public static <E extends Comparable<E>> void sort(ArrayList<E> list)
 *
 *
 *  @author Mustafa Arinmis
 *  @since 01.12.2020
 * */

import java.util.ArrayList;


public class Exercise19_09 {
    public static void main(String[] args) {
        // test program
        ArrayList<Integer> nums = new ArrayList<>();

        for(int i=0; i<10; i++)
            nums.add((int)(Math.random() * 100)  + 1);
        System.out.println(nums);
        sort(nums);
        System.out.println(nums);

    }

    /* insertion sort implemented */
    public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
        for( int i=1; i<list.size(); i++) {
            E key = list.get(i);
            int j = i - 1;

            while(j >= 0 && list.get(j).compareTo(key) == 1) {
                list.set(j+1, list.get(j));
                j--;
            }
            list.set(j+1, key);
        }
    }

}
