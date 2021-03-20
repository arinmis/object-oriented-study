/**
 *  Programming Exercise 19.08
 *
 *  (Shuffle ArrayList ) Write the following method that shuffles an ArrayList :
 *
 *  public static <E> void shuffle(ArrayList<E> list)
 *
 *
 *  @author Mustafa Arinmis
 *  @since 31.12.2020
 * */

import java.util.ArrayList;

public class Exercise19_08 {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        for( int i=0; i<10; i++)
            nums.add(i+1);

        System.out.println(nums); // ordered array list 
        shuffle(nums);
        System.out.println(nums); //shuffled array list
    }
    public static <E> void shuffle(ArrayList<E> list) {
        E temp = list.get(0);
        for(int i=1; i< list.size(); i++) {
            int randIndex = (int)(Math.random() * list.size()); //select random index
            list.set(i-1, list.get(randIndex)); // swap random index value and temp value
            list.set(randIndex, temp);
            temp = list.get(i); // update temp
        }
    }
}
