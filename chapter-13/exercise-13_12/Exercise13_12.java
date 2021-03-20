/**
 *  Programming Exercise 13.12
 *
 *  (Sum the areas of geometric objects) Write a method that sums the areas of all the
 *  geometric objects in an array. The method signature is:
 *
 *  public static double sumArea(GeometricObject[] a)
 *
 *  Write a test program that creates an array of four objects (two circles and two
 *  rectangles) and computes their total area using the sumArea method.
 *
 *  @author Mustafa Arinmis
 *  @since 24.12.2020
 * */

import shapes.*; // I put all geometric object into shapes package

public class Exercise13_12{
    public static void main(String[] args) {
        // testing sum area method 
        GeometricObject[] myObject = new GeometricObject[3];
        myObject[0] = new Circle(1);
        myObject[1] = new Octagon(5);
        myObject[2] = new Rectangle(5, 10);
        
        System.out.println("Sum of all geometric object is: " + sumArea(myObject));
    }
    public static double sumArea(GeometricObject[] a) {
        double total = 0;
        for(GeometricObject geoObj : a) {
            total += geoObj.getArea();
        }

        return total;
    }
}




