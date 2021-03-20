import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



/**
 * Programming exercise - Programming Exercise 12.14
 *
 * (Write/read data) Write a program to create a file named Exercise12_15.txt if
 * number of scores separated by blanks. Write a program that prompts the user
 * to enter the file, reads the scores from the file, and displays their total and
 * average.
 *
 *  @author Mustafa Arinmis
 *  @since 15.11.2020
 * */




public class Scores {
    public static void main(String[] args) {

        if (args[0].length() != 1) {
            System.out.println("Usage: java Scores textFileName");
        }

        File file = new File(args[0]);

        int totScores = 0;
        double avgScores = 0;


        try{
            Scanner input = new Scanner(file);
            int numOfScores = 0;
            while(input.hasNext()) {
                totScores += input.nextInt();
                numOfScores++;
            }

            avgScores = totScores / numOfScores;

        }catch (FileNotFoundException ex) {
            System.out.println("Given file not found: " + args[0]);
        }

        System.out.println("Total scores: " + totScores + "\nAvarage scores: " + avgScores);
    }
}
