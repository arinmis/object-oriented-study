
/**
 *
 *  Introduction to Java Programming - Programming Exercise 12.7
 *
 *
 *  @author Mustafa Arinmis
 *  @since 06.11.2020
 * */

public class Main {
    public static void main(String[] args) {
        // it will print 9
        System.out.println(bin2Dec("1001"));
        // it will throw exception
        System.out.println(bin2Dec("23"));
    }

    public static int bin2Dec(String str) {
        if(!isBinary(str))
            throw new NumberFormatException(str + " is not binary number");

        int result = 0;
        int digit = 0;
        for(int i=str.length()-1; i>=0; i--) {
            if(str.charAt(i) == '1')
                result += Math.pow(2, digit);

            digit++;
        }

        return result;
    }
    public static boolean isBinary(String str) {
        for(int i=0; i<str.length(); i++) {
            if(!(str.charAt(i) == '0' || str.charAt(i) == '1'))
                return false;
        }
        return true;
    }
}