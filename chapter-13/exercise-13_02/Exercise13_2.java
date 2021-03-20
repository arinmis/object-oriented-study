/**
 *  Programming exercise - Programming Exercise 13.3
 *
 *  (Shuffle ArrayList) Write the following method that shuffles an ArrayList of
 * numbers:
 * public static void shuffle(ArrayList<Number> list)
 *
 *  @author Mustafa Arinmis
 *  @since 20.12.2020
 * */

import java.util.ArrayList;

public class Exercise13_3 {
    public static void main(String[] args) {
        ArrayList<Number> nums = new ArrayList<>();
        nums.add(new Integer("2"));
        nums.add(new Double(2.1));
        nums.add(new Double(2.2));
        nums.add(new Double(2.3));
        nums.add(new Double(2.4));
        nums.add(new Double(2.5));

        shuffle(nums);

        System.out.println(nums.toString());
    }

    public static void shuffle(ArrayList<Number> list) {
        Number temp;
        int index;
        for (int i = 0; i < list.size(); i++) {
            index = (int) (Math.random() * list.size());
            temp = list.get(i);
            list.set(i, list.get(index));
            list.set(index, temp);
        }
    }
}
























