/**
 *  Programming Exercise 13.10
 *
 *  (Enable Rectangle comparable) Rewrite the Rectangle class in Listing 13.3 to
 *  extend GeometricObject and implement the Comparable interface. Override
 *  the equals method in the Object class. Two Rectangle objects are equal
 *  if their areas are the same. Draw the UML diagram that involves Rectangle ,
 *  GeometricObject , and Comparable.
 *
 *  UML: https://drive.google.com/file/d/1flvPWqfkJDUIatlKZqDKCGeOtiJarktk/view?usp=sharing
 *  @author Mustafa Arinmis
 *  @since 24.12.2020
 * */


public class Rectangle extends GeometricObject implements Comparable<Rectangle>{
    private double width, height;

    public Rectangle(double width, double height, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle() {
        this(1, 1); //default Rectangle
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public int compareTo(Rectangle r) {
        if(this.getArea() > r.getArea())
            return 1;
        else if(this.getArea() == r.getArea())
            return 0;
        else
            return -1;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Rectangle) {
            return ((Rectangle)obj).getArea() == this.getArea();
        }
        else
            return false;
    }
}
