/**
 *  Programming exercise - Programming Exercise 13.1
 *  (Triangle class) Design a new
 *  Triangle class that extends the abstract
 *  GeometricObject class. Draw the UML diagram for the classes Triangle
 *  and GeometricObject and then implement the Triangle class. Write a test
 *  program that prompts the user to enter three sides of the triangle, a color, and a
 *  Boolean value to indicate whether the triangle is filled. The program should create
 *  a Triangle object with these sides and set the color and filled properties using
 *  the input. The program should display the area, perimeter, color, and true or false
 *  to indicate whether it is filled or not.
 *
 *  UML DIAGRAM: https://drive.google.com/file/d/1k5Wa8zlc1DLMvpwh9dAsCz69VemG6Wk4/view?usp=sharing
 *  @author Mustafa Arinmis
 *  @since 20.12.2020
 * */


import java.util.*;

public class Test {
    public static void main(String[] args) {
       //prompting triangle's info
       Scanner input = new Scanner(System.in);
       System.out.print("Enter 3 side of triangle: ");
       double side1 = input.nextDouble();
       double side2 = input.nextDouble();
       double side3 = input.nextDouble();
       System.out.print("Enter color of the triangle: ");
       String color = input.next();
       System.out.print("Is triangle filled or not? Enter true or false: ");
       boolean filled = input.nextBoolean();

       //create and print triangle
       GeometricObject geometricObject = new Triangle(side1,side2,side3, color, filled);
       System.out.println(geometricObject);
    }
}

