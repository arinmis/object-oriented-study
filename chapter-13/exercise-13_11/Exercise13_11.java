
/**
 *  Programming Exercise 13.11
 *
 *  (The Octagon class) Write a class named Octagon that extends
 *  GeometricObject and implements the Comparable and Cloneable inter-
 *  faces. Assume that all eight sides of the octagon are of equal length. The area can
 *  be computed using the following formula:
 *
 *                  area = (2 + 4/sqrt(2))* side * side
 *
 *  Draw the UML diagram that involves Octagon , GeometricObject ,
 *  Comparable , and Cloneable . Write a test program that creates an Octagon
 *  object with side value 5 and displays its area and perimeter. Create a new object
 *  using the clone method and compare the two objects using the compareTo
 *  method.
 *
 *  UML: https://drive.google.com/file/d/1X5SJ-PfS6L5YwojjvNdePVfZspPqKuso/view?usp=sharing
 *  @author Mustafa Arinmis
 *  @since 24.12.2020
 * */

public class Exercise13_11{
    public static void main(String[] args) {
        Octagon octagon = new Octagon(5);
        System.out.printf("Octagon area is %.2f and perimeter is %.2f\n", octagon.getArea(), octagon.getPerimeter());

        Octagon cloneOctagon = null;
        try {
            cloneOctagon = (Octagon) (octagon.clone());
        }
        catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }

        System.out.println("octagon.compareTo(cloneOctagon) --> " + octagon.compareTo(cloneOctagon));

    }
}




