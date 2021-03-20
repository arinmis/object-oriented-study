/**
 *  Programming exercise - Programming Exercise 12.23
 *
 *  (Process scores in a text file on the Web) Suppose that the text file on the
 *  Web http://cs.armstrong.edu/liang/data/Scores.txt contains an unspecified number
 *  of scores. Write a program that reads the scores from the file and displays their
 *  total and average. Scores are separated by blanks.
 *
 *  @author Mustafa Arinmis
 *  @since 10.12.2020
 * */


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


public class Exercise12_23 {
    public static void main(String[] args)  {
        //url that by provided by the book was broken
        //program will be read txt file url from keyboard
        System.out.println("Enter your txt file url:");
        String tempUrl = new Scanner(System.in).next();

        double total = 0;
        int count = 0;
        try{
            URL url = new URL(tempUrl);
            Scanner input = new Scanner(url.openStream());
            while(input.hasNext()) {
                total += Integer.valueOf(input.next()); // read each scores and add them up
                count++; // count amount of scores
            }

            System.out.println("Total scores: " + total); // display total
            System.out.printf("Average score: %.2f\n", total / count);  //display average
        }
        catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }


    }
}
