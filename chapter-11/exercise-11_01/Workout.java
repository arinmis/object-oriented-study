import java.util.Scanner;

/**
 *
 *  Introduction to Java Programming - Programming Exercise 11.1
 *
 *  @author Mustafa Arinmis
 *  @since 22.08.2020
 *
 * */

public class Workout{
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // asking for triangle sides
        System.out.println("Enter 3 sides of triangle: ");
        double side1 = input.nextDouble();
        double side2 = input.nextDouble();
        double side3 = input.nextDouble();
        //prompting color and is filled or not
        System.out.println("Enter color of triangle: ");
        String color = input.next();
        System.out.println("Is it filled? Enter true or false: ");
        boolean filled = input.nextBoolean();

        Triangle triangle = new Triangle(side1, side2, side3, color, filled);
        System.out.println("Area of triangle: " + triangle.getArea());
        System.out.println("Perimeter of triangle: " + triangle.getPerimeter());
        System.out.println("What is color of triangle: " + triangle.getColor());
        System.out.println("Is triangle filled? : " + triangle.isFilled());

    }
}

class Triangle extends SimpleGeometricObject{
    private double side1=1.0;
    private double side2=1.0;
    private double side3=1.0;

    public Triangle(){

    }

    public Triangle(double side1, double side2, double side3,
                    String color, boolean filled) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
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