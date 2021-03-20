/*Introduction to java Programming, Problem 9.9
 * @author Mustafa Arinmis
 * @since 05.14.2020
 * */


public class RegularPolygon {
    private int n = 3;
    private double side = 1;
    private double x = 0;
    private double y = 0;

    public RegularPolygon() {
    }

    public RegularPolygon(int n, int side) {
        this.n = n;
        this.side = side;
    }

    public RegularPolygon(int n, double side, double x, double y) {
        this.n =n;
        this.side = side;
        this.x = x;
        this.y = y;
    }

    public double getPerimeter() {
        return this.getN() * this.getSide();
    }

    //Area formula: (n * s^2) / (4 * tan(pi/n))
    public double getArea() {
        return (this.getN() * this.getSide() * this.getSide())
                / (4 * Math.tan(Math.PI / this.getN()));
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}

class Test {
    public static void main(String[] args) {

        RegularPolygon rp1 = new RegularPolygon();
        RegularPolygon rp2 = new RegularPolygon(6, 4);
        RegularPolygon rp3 = new RegularPolygon(10, 4, 5.6, 7.8);

        System.out.println("First polygon area: " + rp1.getArea() + " and perimeter: " + rp1.getPerimeter() );
        System.out.println("Second polygon area: " + rp2.getArea() + " and perimeter: " + rp2.getPerimeter() );
        System.out.println("Third polygon area: " + rp3.getArea() + " and perimeter: " + rp3.getPerimeter());
    }
}