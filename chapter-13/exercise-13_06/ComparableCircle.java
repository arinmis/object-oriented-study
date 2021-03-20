public class ComparableCircle extends Circle implements Comparable<Circle> {

    public  ComparableCircle(int radius, String color, boolean filled) {
       super(radius, color, filled);
    }

    public  ComparableCircle(int radius) {
        super(radius);
    }


    public int compareTo(Circle circle) {
        if(super.getArea() > circle.getArea())
            return 1;
        else if((super.getArea() == circle.getArea()))
            return 0;
        else
            return -1;
    }
}
