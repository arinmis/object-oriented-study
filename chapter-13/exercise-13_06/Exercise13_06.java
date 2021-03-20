/**
 *  Programming Exercise 13.6
 *
 *  (The ComparableCircle class) Define a class named ComparableCircle
 *  that extends Circle and implements Comparable . Draw the UML diagram and
 *  implement the compareTo method to compare the circles on the basis of area.
 *  Write a test class to find the larger of two instances of ComparableCircle objects.
 *
 *  UML: https://drive.google.com/file/d/1PZpobSYDi33ZyA3JZ5R-lZ-kS5HXsILa/view?usp=sharing
 *  @author Mustafa Arinmis
 *  @since 24.12.2020
 * */

public class Exercise13_06{
    public static void main(String[] args) {
        //Test class
        ComparableCircle circle1 = new ComparableCircle(15, "purple", false);
        ComparableCircle circle2 = new ComparableCircle(25, "cyan", true);
        System.out.println(circle1.compareTo(circle2));

    }
}