import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Programming exercise - Programming Exercise 12.13
 *
 * (Count characters, words, and lines in a file) Write a program that will count
 * the number of characters, words, and lines in a file. Words are separated by
 * whitespace characters. The file name should be passed as a command-line
 * argument
 *
 *  @author Mustafa Arinmis
 *  @since 15.11.2020
 * */

public class Count{
    public static void main(String[] args) {

        if (args[0].length() != 1) {
            System.out.println("Usage: java Count textFileName");
        }


        File file = new File(args[0]);

        int numOfLine=0;
        int numOfWord = 0;
        int numOfChar = 0;


        try{
            Scanner input = new Scanner(file);

            while(input.hasNext()) {
                String line = input.nextLine();
                numOfLine++;
                numOfChar += line.length();
                numOfWord += line.split(" ").length;
            }

        }catch (FileNotFoundException ex) {
            System.out.println("Given file not found: " + args[0]);
        }


        System.out.println("File " + args[0] + " has:");
        System.out.println(numOfLine + " line\n" + numOfWord + " word\n" + numOfChar + " character\n");

    }
}
