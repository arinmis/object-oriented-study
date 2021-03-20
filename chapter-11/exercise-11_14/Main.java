import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 *  Introduction to Java Programming - Programming Exercise 11.14
 *
 *
 *  @author Mustafa Arinmis
 *  @since 22.08.2020
 *
 * */


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter 2 list which have 5 intgere:");
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();


        System.out.printf("Enter five integers for list1:");
        for(int j=0; j<5; j++) {
            list1.add(input.nextInt());
        }

        System.out.printf("Enter five integers for list2:");
        for(int j=0; j<5; j++) {
            list2.add(input.nextInt());
        }

        ArrayList<Integer> unionList = union(list1, list2);

        System.out.print("The combined list is ");
        for(int i=0; i<unionList.size(); i++) {
            System.out.print(unionList.get(i) + " ");
        }


    }

    public static ArrayList<Integer> union(ArrayList<Integer> list1, ArrayList<Integer> list2) {

        for(int i=0; i<list2.size(); i++) {
            list1.add(list2.get(i));
        }

        return list1;
    }
}