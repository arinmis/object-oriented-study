public class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable{
    private double side;

    public Octagon(double side, String color, boolean filled) {
        super(color, filled);
        this.side = side;
    }

    public Octagon(double side) {
        this.side = side;
    }

    public Octagon () {}

    @Override
    public double getArea() {
        return (2 + 4/Math.sqrt(2)) * side * side;
    }

    @Override
    public double getPerimeter() {
        return 8 * side;
    }

    @Override
    public int compareTo(Octagon o) {
        if(this.getArea() < o.getArea())
            return -1;
        else if(this.getArea() == o.getArea())
            return 0;
        else
            return 1;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof  Octagon)
            return this.getArea() == ((Octagon) obj).getArea();
        else
            return false;
    }

}
