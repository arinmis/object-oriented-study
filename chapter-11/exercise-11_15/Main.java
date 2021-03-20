import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 *  Introduction to Java Programming - Programming Exercise 11.15
 *
 *  In solution, I firstly chose one point inside the polygon the using that point
 *  I created subtriangles(with poylgons which have n corners you get n subtriangle except 3 corner one)
 *  Then I sum up all subtriangle areas and printed it as a result
 *
 *  @author Mustafa Arinmis
 *  @since 22.08.2020
 *
 * */


public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of the points:");
        double numOfPoint = input.nextInt();
        double totalArea = 0;

        ArrayList<MyPoint> points = new ArrayList<>();
        System.out.println("Enter the coordinates of the points:");

        for(int i=0; i<numOfPoint; i++) {
            points.add(new MyPoint(input.nextDouble(), input.nextDouble()));
        }

        //if poylgon is triange it only has 1 subtriangle
        if(numOfPoint == 3) {
            totalArea =  triangleArea(points.get(0), points.get(1), points.get(2));
            System.out.printf("The total area is %.2f", totalArea);
            System.exit(0);
        }

        MyPoint midPoint = getMidPoint(points);


        for(int i=0; i<points.size() - 1; i++) {
            totalArea += triangleArea(midPoint, points.get(i), points.get(i + 1));
        }

        System.out.printf("The total area is %.2f", totalArea);

    }


    public static MyPoint getMidPoint(ArrayList<MyPoint> points) {
        /*
        * This method return point that inside the polygon
        * */

        MyPoint tempPoint = new MyPoint((points.get(0).getX() + points.get(1).getX()) / 2,
                (points.get(0).getY() + points.get(1).getY()) / 2);

        return new MyPoint((tempPoint.getX() + points.get(2).getX()) / 2,
                (tempPoint.getX() + points.get(2).getX()) / 2 );
    }

    public static double triangleArea(MyPoint p1, MyPoint p2, MyPoint p3) {
        // Triange area calculation with heron formula
        double distance1 = p1.distance(p2);
        double distance2 = p1.distance(p3);
        double distance3 = p2.distance(p3);
        double s = ( distance1 + distance2 + distance3) / 2;

        return Math.sqrt(s * (s - distance1) * (s - distance2) * (s - distance3));
    }
}

class MyPoint {
    private double x;
    private double y;

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public MyPoint() {
        this(0, 0);
    }

    public double distance(MyPoint point) {
        double xDis = Math.pow((x - point.getX()), 2);
        double yDis = Math.pow((y - point.getY()), 2);
        return Math.sqrt(xDis + yDis);
    }

    public double distance(double x, double y) {
        double xDis = Math.pow((this.x - x), 2);
        double yDis = Math.pow((this.y - y), 2);
        return Math.sqrt(xDis + yDis);
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

}

