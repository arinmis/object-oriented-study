import java.util.ArrayList;
import java.util.Scanner;

/**
 *  Programming Exercise 19.02
 *
 *  (Implement GenericStack using inheritance) In Listing 19.1, GenericStack is
 *  implemented using composition. Define a new stack class that extends ArrayList .
 *  Draw the UML diagram for the classes and then implement GenericStack .
 *  Write a test program that prompts the user to enter five strings and displays them in
 *  reverse order.
 *  
 *  UML: https://drive.google.com/file/d/1NmLG0dWQOfVDDX950dJR3bGwsKmUKjnX/view?usp=sharing
 *  @author Mustafa Arinmis
 *  @since 30.12.2020
 * */


public class Exercise19_02{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 5 item: ");

        GenericStack<String> stack = new GenericStack<>();

        for(int i=0; i<5; i++)
            stack.push(input.next());

        System.out.println("Printing stack's items in reverse order:");

        while(!stack.isEmpty())
            System.out.print(stack.pop() + " ");

    }
}
