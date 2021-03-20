import java.util.Scanner;
/**
 *
 *  Introduction to Java Programming - 10.26
 *
 *  @author Mustafa Arinmis
 *  @since 13.08.2020
 *
 * */
public class Workout {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String operation = input.nextLine();
        System.out.println(result(elements(operation)));
    }
    public static String[] elements(String str) {
        String[] strings = new String[3];
        int count = 0;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) != ' ') {
                strings[count++] = str.substring(i, i+1);
            }
        }

        return strings;
    }
    public static int result(String[] strings) {
        int num1 = Integer.valueOf(strings[0]);
        int num2 = Integer.valueOf(strings[2]);

        switch(strings[1]) {
            case "+":
                return num1+num2;
            case "-":
                return num1+num2;
            case "*":
                return num1*num2;
            case "/":
                return num1/num2;
        }
        return 0;
    }

}

