/**
 *  Programming Exercise 13.8
 *
 *  (Revise the MyStack class) Rewrite the MyStack class in Listing 11.10 to perform
 *  a deep copy of the list field.
 *
 *  @author Mustafa Arinmis
 *  @since 24.12.2020
 * */

public class Exercise13_08{
    public static void main(String[] args) {
        MyStack stack1 = new MyStack();
        stack1.push("Element1");
        stack1.push("Element2");

        MyStack stack2 = null;
        try {
            stack2 = (MyStack)stack1.clone(); //deep copy of stack1
        }catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }

        stack2.push("Element3"); //pushing extra to cloned stack element for testing

        System.out.println("Stack 1: " + stack1);
        System.out.println("Stack 2: " + stack2);
    }
}
