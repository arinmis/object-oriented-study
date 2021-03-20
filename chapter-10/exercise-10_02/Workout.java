import java.awt.geom.Line2D;

/**
 *  @author Mustafa Arınmış
 *  @since 30.06.2020
 *
 *  Introduction to Java Programming - 10.12
 *  this is not completed, there are a lot of bug, look at heron formula espacially
 *
 * */


public class Workout {
    public static void main(String[] args) {


        Triangle2D t1 = new Triangle2D(new MyPoint(0,0), new MyPoint(0,3), new MyPoint(4, 0));
        Triangle2D t2 = new Triangle2D(new MyPoint(1,0), new MyPoint(0,3), new MyPoint(4, 0));
        Triangle2D t3 = new Triangle2D(new MyPoint(0,0), new MyPoint(0,1), new MyPoint(1, 0));

        System.out.println("Area of 3 height, 4 base rectangle is: " + t1.getArea());
        System.out.println("Area of 3 height, 4 base rectangle is: " + t1.getArea());
        System.out.println("Is t1 and t2 overlaps: " + t1.overlaps(t2));
        System.out.println("Is t1 contain point (1, 1): " + t1.contains(new MyPoint(1,1)));
        System.out.println("Is t1 contain point (9, 9): " + t1.contains(new MyPoint(9,9)));
        System.out.println("Is t1 contain t3: " + t1.contains(t3));
        System.out.println("Is t1 contain t2: " + t1.contains(t2));


    }
}


class Triangle2D {

    private MyPoint p1;
    private MyPoint p2;
    private MyPoint p3;


    public void setP1(MyPoint p1) {
        this.p1 = p1;
    }

    public void setP2(MyPoint p2) {
        this.p2 = p2;
    }

    public void setP3(MyPoint p3) {
        this.p3 = p3;
    }


    public MyPoint getP1() {
        return p1;
    }

    public MyPoint getP2() {
        return p2;
    }

    public MyPoint getP3() {
        return p3;
    }

    public Triangle2D(MyPoint p1, MyPoint p2, MyPoint p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public Triangle2D() {
        this(new MyPoint(0,0), new MyPoint(1, 1), new MyPoint(2, 5));
    }

    public double getArea() {
        // calculating each sides
        double side1 = Math.sqrt(Math.pow(p1.getX() - p2.getY(), 2) + Math.pow(p1.getY() - p2.getY(),2));
        double side2 = Math.sqrt(Math.pow(p1.getX() - p3.getY(), 2) + Math.pow(p1.getY() - p3.getY(),2));
        double side3 = Math.sqrt(Math.pow(p3.getX() - p2.getY(), 2) + Math.pow(p3.getY() - p2.getY(),2));

        // calculating s
        double s = (side1 + side2 + side3) / 2;

        double area = Math.sqrt(s * (s-side1) * (s-side2) * (s-side3));

        return area;
    }

    public double getArea(MyPoint p1, MyPoint p2, MyPoint p3) {
        // calculating each sides
        double side1 = Math.sqrt(Math.pow(p1.getX() - p2.getY(), 2) + Math.pow(p1.getY() - p2.getY(),2));
        double side2 = Math.sqrt(Math.pow(p1.getX() - p3.getY(), 2) + Math.pow(p1.getY() - p3.getY(),2));
        double side3 = Math.sqrt(Math.pow(p3.getX() - p2.getY(), 2) + Math.pow(p3.getY() - p2.getY(),2));

        // calculating s
        double s = (side1 + side2 + side3) / 2.0;

        // return area
        double temp = s * (s-side1) * (s-side2) * (s-side3);
        double area = Math.sqrt(temp);

        return area;
    }

    public double getPerimeter() {
        double side1 = Math.sqrt(Math.pow(p1.getX() - p2.getY(), 2) + Math.pow(p1.getY() - p2.getY(),2));
        double side2 = Math.sqrt(Math.pow(p1.getX() - p3.getY(), 2) + Math.pow(p1.getY() - p3.getY(),2));
        double side3 = Math.sqrt(Math.pow(p3.getX() - p2.getY(), 2) + Math.pow(p3.getY() - p2.getY(),2));

        return side1 + side2 + side3;
    }

    // if given point inside the triangle
    // sum of area of tree sub triangle must equal bigger one
    public boolean contains(MyPoint point) {
        double subArea1 = getArea(point, p1, p2);
        double subArea2 = getArea(point, p1, p3);
        double subArea3 = getArea(point, p2, p3);

        return subArea1+subArea2+subArea3 == this.getArea();
    }

    public boolean contains(Triangle2D t) {
        return this.contains(t.getP1()) && this.contains(t.getP2())
                && this.contains(t.getP3());
    }

    public boolean overlaps(Triangle2D t) {

        //if any edges of triangle intersect
        //that mean those triangle overlaps
        // Edge1 and given edge1, edge2 ,edge3
        boolean case1 = Line2D.linesIntersect(this.p1.getX(), this.p1.getY(), this.p2.getX(), this.p2.getY(),
                t.p1.getX(), t.p1.getY(), t.p2.getX(), t.p2.getY());
        boolean case2 = Line2D.linesIntersect(this.p1.getX(), this.p1.getY(), this.p2.getX(), this.p2.getY(),
                t.p2.getX(), t.p2.getY(), t.p3.getX(), t.p3.getY());
        boolean case3 = Line2D.linesIntersect(this.p1.getX(), this.p1.getY(), this.p2.getX(), this.p2.getY(),
                t.p1.getX(), t.p1.getY(), t.p3.getX(), t.p3.getY());
        // Edge2 and given edge1, edge2 ,edge3
        boolean case4 = Line2D.linesIntersect(this.p2.getX(), this.p2.getY(), this.p3.getX(), this.p3.getY(),
                t.p1.getX(), t.p1.getY(), t.p2.getX(), t.p2.getY());
        boolean case5 = Line2D.linesIntersect(this.p2.getX(), this.p2.getY(), this.p3.getX(), this.p3.getY(),
                t.p2.getX(), t.p2.getY(), t.p3.getX(), t.p3.getY());
        boolean case6 = Line2D.linesIntersect(this.p2.getX(), this.p2.getY(), this.p3.getX(), this.p3.getY(),
                t.p1.getX(), t.p1.getY(), t.p3.getX(), t.p3.getY());

        // Edge3 and given edge1, edge2 ,edge3
        boolean case7 = Line2D.linesIntersect(this.p1.getX(), this.p1.getY(), this.p3.getX(), this.p3.getY(),
                t.p1.getX(), t.p1.getY(), t.p2.getX(), t.p2.getY());
        boolean case8 = Line2D.linesIntersect(this.p1.getX(), this.p1.getY(), this.p3.getX(), this.p3.getY(),
                t.p2.getX(), t.p2.getY(), t.p3.getX(), t.p3.getY());
        boolean case9 = Line2D.linesIntersect(this.p1.getX(), this.p1.getY(), this.p3.getX(), this.p3.getY(),
                t.p1.getX(), t.p1.getY(), t.p3.getX(), t.p3.getY());

        // to overlap 1 intersection enough
        boolean result = case1 || case2 || case3 || case4 || case5 || case6 || case7 || case8 || case9;

        return result;

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

