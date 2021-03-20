/**
 *  Programming Exercise 13.7
 *
 *  (The Colorable interface) Design an interface named Colorable with a void
 *  method named howToColor() . Every class of a colorable object must imple-
 *  ment the Colorable interface. Design a class named Square that extends
 *  GeometricObject and implements Colorable . Implement howToColor to
 *  display the message Color all four sides .
 *
 *  Draw a UML diagram that involves Colorable , Square , and GeometricObject .
 *  Write a test program that creates an array of five GeometricObject s. For each
 *  object in the array, display its area and invoke its howToColor method if it is
 *  colorable.
 *
 *  UML: https://drive.google.com/file/d/1PZpobSYDi33ZyA3JZ5R-lZ-kS5HXsILa/view?usp=sharing
 *  @author Mustafa Arinmis
 *  @since 24.12.2020
 * */

public class Exercise13_07{
    public static void main(String[] args) {
        GeometricObject[] geoArray = {new Circle(1), new Circle(2), new Square(3),
                new Square(4), new Square(5)};

        for(GeometricObject geoObj : geoArray) {
            System.out.println(geoObj.getArea());
            if(geoObj instanceof Colorable)
                ((Square) geoObj).howToColor();
        }
    }
}
