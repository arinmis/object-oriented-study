/**
 *  Programming exercise - Programming Exercise 12.21
 *
 *  (Data sorted?) Write a program that reads the strings from file SortedStrings.
 *  txt and reports whether the strings in the files are stored in increasing order.
 *  If the strings are not sorted in the file, displays the first two strings that are out
 *  of the order.
 *
 *  @author Mustafa Arinmis
 *  @since 10.12.2020
 * */

import java.io.*;
import java.util.Scanner;

public class Exercise12_21 {
    public static void main(String[] args)  {
        File file = new File("SortedStrings.txt");

        try(Scanner input = new Scanner(file)) {
            String str1 = input.next();
            while (input.hasNext()) {
                String str2 = input.next();
                if (!isLess(str1, str2)) {
                    System.out.println("Strings are out of order: ... " + str1 + ", " + str2 + " ...");
                    System.exit(-1);
                }
                str1 = str2; // update last str
            }
        }catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println("Strings are sorted");
    }

    // check whether first string is less than second one or not
    public static boolean isLess(String str1, String str2) {
        if(str1.equals(str2)) // if both are same return true
            return true;

        int minLen = Math.min(str1.length(), str2.length());

        for(int i=0; i<minLen; i++) {
            if(str1.charAt(i) > str2.charAt(i))
                return false;
            else if(str1.charAt(i) < str2.charAt(i))
                return true; // if first letter less, no need to check others
        }
        if(str1.length() > str2.length()) // assume str1 is "abcd" and str2 is "abc"
            return false; // in this case "abcd" came before "abc"

        return true;
    }
}