import java.util.Scanner;

/**
 *
 *  Introduction to Java Programming - 10.15
 *
 *  @author Mustafa Arınmış
 *  @since 30.06.2020
 *
 * */

public class Workout{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 5 point, in order x and y for each");
        double[][] points = new double[5][2];

        for(int i=0; i<points.length; i++) {
            System.out.println("Enter x" + (i+1) + ": ");
            points[i][0] = input.nextDouble();
            System.out.println("Enter y" + (i+1) + ": ");
            points[i][1] = input.nextDouble();
        }


        MyRectangle2D rectangle = getRectangle(points);
        System.out.println("Minimun bounding rectangle's:");
        System.out.println("width = " + rectangle.getWidth());
        System.out.println("heigth = " + rectangle.getHeight());
        System.out.println("Center conrdinates (" + rectangle.getCenterX()
                +", " + rectangle.getCenterY() + ")");

    }

    public static MyRectangle2D getRectangle(double[][] points) {
        //Find xMax, xMin, yMax and yMin from given points
        // I set first point as min and max
        double xMin = points[0][0];
        double xMax = points[0][0];
        double yMin = points[0][1];
        double yMax = points[0][1];

        for(int i=1; i<points.length; i++) {
            xMax = Math.max(xMax, points[i][0]);
            xMin = Math.min(xMin, points[i][0]);
            yMax = Math.max(yMax, points[i][1]);
            yMin = Math.min(yMin, points[i][1]);
        }

        double width = xMax - xMin;
        double height = yMax - yMin;

        double xCenter = (xMax + xMin)/2;
        double yCenter = (yMax + yMin)/2;

        MyRectangle2D rectangle2D = new MyRectangle2D(xCenter, yCenter, width, height);

        return rectangle2D;
    }
}

class MyRectangle2D {

    // rectangle sides are paralled to x or y axis
    private double centerX;
    private double centerY;
    private double width;
    private double height;

    public MyRectangle2D(double centerX, double centerY, double width, double height) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.width = width;
        this.height = height;
    }

    public MyRectangle2D() {
        this(0, 0, 1 , 1);
    }

    public double getArea() {
        return this.height * this.width;
    }

    public double getPerimeter() {
        return 2 * (this.height + this.width);
    }

    public boolean contains(double x, double y) {
        //if x in range [centerX+height/2, centerX-height/2]
        //and if y in range [centerY+width/2, centerY-width/2]
        //return true else return false
        boolean inXRange = x <= centerX+height/2 && x >= centerX-height/2;
        boolean inYRAnge = y <= centerY+height/2 && y >= centerX-height/2;

        return inXRange && inYRAnge;
    }

    public boolean contains(MyRectangle2D r) {
        // height and weight of big rectangle must be grater than give
        if( this.height < r.height || this.width < r.width)
            return false;

        double xDistance = Math.abs(centerX - r.getCenterX());
        double yDistance = Math.abs(centerY - r.getCenterY());

        // y distance and x distance have to provide those conditions

        if( xDistance > this.centerX + (width/2 + r.getWidth())/2
                || xDistance < this.centerX - (width/2 + r.getWidth()/2))
            return false;


        if( yDistance > this.centerY + (height/2 + r.getHeight())/2
                || yDistance < this.centerY - (height/2 + r.getHeight()/2))
            return false;

        // If given rectangle(r) provide all condition then return true
        return  true;
    }

    public boolean overlaps(MyRectangle2D r) {
        double xDistance = Math.abs(centerX - r.getCenterX());
        double yDistance = Math.abs(centerY - r.getCenterY());

        if( xDistance < (this.width + r.getWidth())/2
                && yDistance < (this.height + r.getHeight())/2)
            return true;

        return false;

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

    public double getCenterX() {
        return centerX;
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }


}