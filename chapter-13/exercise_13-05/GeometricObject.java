import java.util.Date;

public abstract class GeometricObject implements Comparable<GeometricObject> {

    private String color;
    private boolean filled;
    private Date dateCreated;

    protected GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
        this.dateCreated = new Date();

    }
    protected GeometricObject() {
        this("white", false); //default triangle white and not filled
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }


    public abstract double getArea();

    public abstract double getPerimeter();

    @Override
    public int compareTo(GeometricObject geometricObject) {
        if(this.getArea() > geometricObject.getArea())
            return 1;
        else if(this.getArea() > geometricObject.getArea())
            return 0;
        else
            return -1;
    }

    public static GeometricObject max(GeometricObject g1, GeometricObject g2) {
        if(g1.getArea() >= g2.getArea())
            return g1;
        else
            return g2;
    }
    @Override
    public String toString() {
        return "Color: " + color + ", Filled: " + isFilled() + ", Area: " + getArea();
    }

}
