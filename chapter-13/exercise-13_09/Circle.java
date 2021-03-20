/**
 *  Programming Exercise 13.09
 *
 *  (Enable Circle comparable) Rewrite the Circle class in Listing 13.2 to extend
 *  GeometricObject and implement the Comparable interface. Override the
 *  equals method in the Object class. Two Circle objects are equal if their radii
 *  are the same. Draw the UML diagram that involves Circle , GeometricObject ,
 *  and Comparable .
 *
 *  UML: https://drive.google.com/file/d/1OJqiHQsiqivTU7cBkyLbnptwsEaxGIvP/view?usp=sharing
 *  @author Mustafa Arinmis
 *  @since 24.12.2020
 * */

public class Circle extends GeometricObject implements Comparable<Circle>{
    private double radius;


    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public Circle(double radius) {
        this.radius = radius; //default radius 1
    }

    public Circle() {
        this.radius = 1; //default radius 1
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public double getDiameter() {
        return 2 * radius;
    }

    @Override
    public int compareTo(Circle circle) {
        if(this.getArea() > circle.getArea())
            return 1;
        else if(this.getArea() == circle.getArea())
            return 0;
        else
            return -1;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Circle) {
            return ((Circle)obj).getRadius() == this.radius;
        }
        else return false;
    }

}
