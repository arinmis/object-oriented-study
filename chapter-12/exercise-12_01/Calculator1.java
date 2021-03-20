import java.util.Scanner;

/**
 *
 *  Introduction to Java Programming - Programming Exercise 12.1
 *  Command line calculator with exception handling
 *
 *  @author Mustafa Arinmis
 *  @since 04.11.2020
 *
 * */

public class Calculator {
    public static void main(String[] args) {
        String num1 = "-1";
        String num2 = "-1";

        try {
            num1 = args[0];

            if(!isNumber(num1)) {
                throw new NumberFormatException(num1);
            }
        }
        catch (NumberFormatException ex) {
            System.out.println("Wrong input: " + ex.getMessage());
            System.exit(0);
        }


        char operation = args[1].charAt(0);

        try {
            num2 = args[2];

            if(!isNumber(num2)) {
                throw new NumberFormatException(num2);
            }
        }

        catch (NumberFormatException ex) {
            System.out.println("Wrong input: " + ex.getMessage());
            System.exit(0);
        }

        calculate(Integer.valueOf(num1), Integer.valueOf(num2), operation);


    }

    public static boolean isNumber(String str) {
        for(int i=0; i<str.length(); i++) {
            if( str.charAt(i) < (int)'0' || str.charAt(i) > (int)'9')
                return false;
        }

        return true;
    }

    public static void calculate(int num1, int num2, char operation) {
        switch (operation) {
            case '+':
                System.out.println(num1+num2);
                break;
            case '-':
                System.out.println(num1-num2);
                break;
            case 'x':
                System.out.println(num1*num2);
                break;
            case '/':
                System.out.println(num1/num2);
        }
    }

}
