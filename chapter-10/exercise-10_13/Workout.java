
/**
 *  @author Mustafa Arınmış
 *  @since 30.06.2020
 *
 *  Introduction to Java Programming - 10.13
 *
 * */


public class Workout {
    public static void main(String[] args) {

        MyRectangle2D r = new MyRectangle2D(1, 1, 2, 2);
        System.out.println("Rectangle r features: center(1, 1), width=2, height=2");
        System.out.println("area of rectangle r is :" + r.getArea());
        System.out.println("perimeter of rectangle r is:" + r.getArea());
        System.out.println("Is r contain point (.9, .9)? : "+ r.contains(.9, .9));
        System.out.println("Is r contain point (4, 4)? : "+ r.contains(4, 4));
        System.out.println("Is r rectangle .2 x .2 centered(.1, .1) ? : "+ r.contains(new MyRectangle2D(.1, .1, .2, .2)));
        System.out.println("Is r rectangle 4 x 4 centered(1, 1) ? : "+ r.contains(new MyRectangle2D(4, 4, 1, 1)));
        System.out.println("Is r rectangle 2 x 2 centered(2, 2) ? : "+ r.contains(new MyRectangle2D(2, 2, 2, 2)));
        System.out.println("Is r rectangle 6 x 6 centered(2, 2) ? : "+ r.contains(new MyRectangle2D(6, 6, 2, 2)));

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

