import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 *  Introduction to Java Programming - Programming Exercise 11.11
 *
 *
 *  @author Mustafa Arinmis
 *  @since 22.08.2020
 *
 * */

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Enter 5 integer, I will sort them");

        for(int i=0; i<5; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            list.add(input.nextInt());
        }
        System.out.println("\nHere sorted list: ");
        sort(list);
        System.out.println(list);

    }

    public static void sort(ArrayList<Integer> list){
            //Bubble sort algorithm
            int temp=0;
            for(int j=list.size()-1; j>=0; j-- ) {
                for(int i=0; i<j; i++) {
                    if(list.get(i) > list.get(i + 1)) {
                        temp = list.get(i);
                        list.set(i, list.get(i + 1));
                        list.set(i + 1, temp);
                    }
                }
            }
        }
    }
