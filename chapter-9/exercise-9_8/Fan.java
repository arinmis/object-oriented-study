/*Introduction to java Programming, Problem 9.8
 * @author Mustafa Arinmis
 * @since 05.14.2020
 * */

public class Fan {
   final int SLOW = 1;
   final int MEDIUM = 2;
   final int FAST = 3;

   private int speed = SLOW;
   private boolean on = false;
   private double radius = 5;
   private String color = "blue";

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        if(this.isOn()) {
            return "Fan Speed: " + this.getSpeed()
                    + "\nFan Color: " + this.getColor()
                    + "\nFan Radius: " + this.getRadius();
        }
        else {
            return "fan is off";
        }
    }

}
class Test {
    public static void main(String[] args) {
        Fan fan = new Fan();
        fan.setSpeed(fan.FAST);
        fan.setColor("yellow");
        fan.setRadius(10);
        fan.setOn(true);

        System.out.println(fan.toString());
    }
}
