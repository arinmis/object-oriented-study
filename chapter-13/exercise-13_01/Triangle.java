public class Triangle extends GeometricObject{
    private double side1, side2, side3;

    public Triangle(String color, boolean filled) {
        super(color, filled);
        this.side1 = 0;
        this.side2 = 0;
        this.side3 = 0;
    }
    public Triangle(double side1, double side2, double side3, String color, boolean filled) {
        this(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double getArea() {
        /*Heron formula used*/
        Double s = (side1 + side2 + side3)/2;

        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
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
