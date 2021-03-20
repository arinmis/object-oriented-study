import java.util.ArrayList;
import java.util.Scanner;

/**
 *  Programming Exercise 19.03
 *
 *  (Distinct elements in ArrayList ) Write the following method that returns a new
 *  ArrayList . The new list contains the non-duplicate elements from the original list.
 *  public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list)
 *
 *  @author Mustafa Arinmis
 *  @since 31.12.2020
 * */


public class Exercise19_03{
    public static void main(String[] args) {

        //test program
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<5; i++) {
            int times = (int)(Math.random() * 10); // add loop variable i random amount times
            for(int j=0; j<times; j++ )
                list.add(i);
        }
        //repetitive list
        System.out.println(list);

        //distinct list
        System.out.println(removeDuplicates(list));
    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> uniqueList = new ArrayList<>();
        for(E item : list) {
            if( !uniqueList.contains(item))
                uniqueList.add(item);
        }
        return uniqueList;
    }
}
