import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 *  Introduction to Java Programming - Programming Exercise 11.13
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

        System.out.println("Enter 10 ineger: ");

        for(int i=0; i<10; i++) {
            list.add(input.nextInt());
        }

        removeDuplicate(list);
        System.out.printf("Unique list: " + list);

    }

    public static void removeDuplicate(ArrayList<Integer> list) {
        ArrayList<Integer> tempList = new ArrayList<>();

        for(int i=0; i<list.size(); i++) {
            if(tempList.contains(list.get(i))) {
                list.remove(i--);
            }
            else {
                tempList.add(list.get(i));
            }
        }
    }
}
//class MyStack {
//    private ArrayList<Object> list = new ArrayList<>();
//
//    public boolean isEmpty() {
//        return list.isEmpty();
//    }
//
//    public int getSize() {
//        return list.size();
//    }
//
//    public Object peek() {
//        return list.get(getSize() - 1);
//
//    }   public Object pop() {
//        Object o = list.get(getSize() - 1);
//        list.remove(getSize() - 1);
//        return o;
//    }
//
//    public void push(Object o) {
//        list.add(o);
//    }
//
//    @Override
//    public String toString() {
//        return "stack: " + list.toString();
//    }
//}

//class Stack extends  ArrayList<Object>{
//
//}