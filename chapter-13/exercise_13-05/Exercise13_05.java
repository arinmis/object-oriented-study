/**
 *  Programming Exercise 13.5
 *
 *  (Enable GeometricObject comparable) Modify the GeometricObject class
 *  to implement the Comparable interface, and define a static max method in the
 *  GeometricObject class for finding the larger of two GeometricObject objects.
 *  Draw the UML diagram and implement the new GeometricObject class. Write
 *  a test program that uses the max method to find the larger of two circles and the
 *  larger of two rectangles.
 *
 *  UML: https://drive.google.com/file/d/1ti4YV3p-wFidQc-TpArSI4Xi5SwOy_Kb/view?usp=sharing
 *  @author Mustafa Arinmis
 *  @since 23.12.2020
 * */

public class Exercise13_05{
    public static void main(String[] args) {
        Circle circle1 = new Circle(5, "purple", false);
        Circle circle2 = new Circle(15, "cyan", true);
        System.out.println("Greater circle --> " + GeometricObject.max(circle1, circle2));

        Rectangle rectangle1 = new Rectangle(2, 3, "red", false);
        Rectangle rectangle2 = new Rectangle(4, 5, "green", true);
        System.out.println("Greater rectangle: " + GeometricObject.max(rectangle1, rectangle2));
    }
}