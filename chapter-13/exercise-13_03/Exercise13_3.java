/**
 *  Programming Exercise 13.3
 *
 *  (Shuffle ArrayList) Write the following method that shuffles an ArrayList of
 *  numbers:
 *
 *  public static void shuffle(ArrayList<Number> list)
 *
 *  @author Mustafa Arinmis
 *  @since 23.12.2020
 * */

import java.util.ArrayList;

public class Exercise13_3 {
    public static void main(String[] args) {
        ArrayList<Number> nums = new ArrayList<>();
        nums.add(new Double(1));
        nums.add(new Integer("30"));
        nums.add(new Double(2));
        nums.add(new Integer("-1"));
        nums.add(new Double(2));

        sort(nums); 

        System.out.println(nums.toString());
    }

    public static void sort(ArrayList<Number> list) {
        /* insertion sort implemented*/
        for(int i=1; i<list.size(); i++) {
            Number value = list.get(i);
            for(int j=i-1; j>-1; j--) {
                if(value.doubleValue() > list.get(j).doubleValue())
                    break;
                
                list.set(j+1, list.get(j));
                list.set(j, value);
            }
        }
    }
}
