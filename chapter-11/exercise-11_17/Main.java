import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 *  Introduction to Java Programming - Programming Exercise 11.17
 *
 *  @author Mustafa Arinmis
 *  @since 22.08.2020
 *
 * */


public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer m: ");
        int number = input.nextInt();


        ArrayList<Integer> factors = new ArrayList<>();
        int numberTemp = number;
        for(int i=2; i<=(int)Math.sqrt(numberTemp) || i<4; i++) {
            if(isPrime(numberTemp)) {
                factors.add(numberTemp);
                break;
            }

            if( (numberTemp % i == 0 && isPrime(i))) {
                factors.add(i);
                numberTemp /= i;
                i=1;
            }
        }

        int perFac = perfectFac(factors);
        System.out.println("The smallest number n for m * n to be a perfect square is " + perFac +
                " m * n is " + (perFac * number) );
        System.out.println();


    }
    public static int perfectFac(ArrayList<Integer> factors) {
        int perfectFactor = 1;
        for (int i = 0; i < factors.size(); i++) {
            if (i == factors.size() - 1) {
                perfectFactor *= factors.get(i);
                break;
            }
            else if (factors.get(i) != factors.get(i + 1)) {
                perfectFactor *= factors.get(i);
            } else {
                //we have to skip pair ones
                i++;
            }
        }
        return perfectFactor;
    }

    public static boolean isPrime(int num) {
        for(int i=2; i<=(int)Math.sqrt(num); i++) {
            if(num % i == 0)
                return false;
        }
        return true;
    }
}

