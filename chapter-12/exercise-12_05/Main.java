
/**
 *
 *  Introduction to Java Programming - Programming Exercise 12.5
 *
 *  Updated version of "Programming exercise 11.1". Now Triangle
 *  class constructor can throw exception if user enter invalid
 *  triangle sides.
 *
 *  @author Mustafa Arinmis
 *  @since 06.11.2020
 * */

public class Main {
    public static void main(String[] args) {
        try {
            Triangle triangle = new Triangle(1, 1, 8, "red", true);
        }
        catch (IllegalTriangleException ex) {
            System.out.println("Exception handled");
        }

    }

}
class Triangle extends SimpleGeometricObject{
    private double side1=1.0;
    private double side2=1.0;
    private double side3=1.0;

    public Triangle(){

    }

    public Triangle(double side1, double side2, double side3,
                    String color, boolean filled) throws  IllegalTriangleException {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        //In a triangle, the sum of any two sides is
        //greater than the other side.
        if(side1+side2 < side3 || side1+side3 < side2 || side3+side2 < side1 ) {
            throw new IllegalTriangleException("Invalid triangle sides");
        }
    }
    // Heron formula implemented
    public double getArea() {
        double s = (side1+side2+side3)/2;
        return Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
    }

    public double getPerimeter(){
        return side1+side2+side3;
    }

    @Override
    public String toString(){
        return "Triangle: side1 = " + side1 + " side2 = " + side2 +
                " side3 = " + side3;
    }


    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

}

class SimpleGeometricObject {
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;
    /** Construct a default geometric object */
    public SimpleGeometricObject() {
        dateCreated = new java.util.Date();
    }
    /** Construct a geometric object with the specified color
     * and filled value */
    public SimpleGeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }
    /** Return color */
    public String getColor() {
        return color;
    }
    /** Set a new color */
    public void setColor(String color) {
        this.color = color;
    }
    /** Return filled. Since filled is boolean,
     its getter method is named isFilled */
    public boolean isFilled() {
        return filled;
    }
    /** Set a new filled */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    /** Get dateCreated */
    public java.util.Date getDateCreated() {
        return dateCreated;
    }
    /** Return a string representation of this object */
    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color +
                " and filled: " + filled;
    }
}

class IllegalTriangleException extends Exception {

    public IllegalTriangleException(){}

    public IllegalTriangleException(String message) {
        super(message);

    }
}