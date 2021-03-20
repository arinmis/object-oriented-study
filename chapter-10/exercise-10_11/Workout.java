/**
 *  @author Mustafa Arınmış
 *  @since 30.06.2020
 *
 *  Introduction to Java Programming - 10.11
 *
 * */



import javax.crypto.CipherSpi;
import java.util.ArrayList;

public class Workout {
    public static void main(String[] args) {
        Circle2D c1 = new Circle2D(2, 2, 2);
        System.out.println("Area -->" + c1.getArea());
        System.out.println("Perimeter -->" + c1.getPerimeter());
        System.out.println("c1 contains point (3,3) --> " + c1.contains(3,3));
        System.out.println("c1 contains circle (2, 2, 1) --> " + c1.contains(new Circle2D(2, 2, 1)));
        System.out.println("c1 overlaps circle(0, 0, 2) --> " + c1.overlaps(new Circle2D(0, 0, 2)));

    }
}

class Circle2D {

    private double x;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    private double y;
    private double radius;

    public Circle2D(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public Circle2D() {
        this(0, 0, 1);
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public boolean contains(double x, double y) {
        // distance between dot and circle center
        double distance = Math.sqrt(Math.pow((this.x-x), 2) + Math.pow((this.y-y),2));
        return distance <= radius;
    }

    public boolean contains(Circle2D circle) {
        if(this.contains(circle.getX(), circle.getY())
            && this.getArea() >= circle.getArea()) {

            return true;
        }

        return false;
    }

    public boolean overlaps(Circle2D circle) {
        // they overlaps if r1+r2 < distance between centers
        double distance = Math.sqrt(Math.pow((this.x-x), 2) + Math.pow((this.y-y),2));
        if((radius + circle.getRadius()) > distance)
            return true;
        return false;
    }



}
