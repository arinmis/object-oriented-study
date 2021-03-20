import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;



/**
 * Programming exercise - Programming Exercise 12.15
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
    public static void main(String[] args) throws IOException {

        File file = new File("Exercise12_15.txt");

        if(!file.exists()) {
            if(file.createNewFile())
                System.out.println("Exercise12_15.txt created.");
            else{
                System.out.println("File couldn't :( created something wrong.");
                System.exit(0);
            }
        }

        PrintWriter output = new PrintWriter(file);
        for(int i=0; i<100; i++)
            output.println((int)(Math.random() * 100)  + 1);

        output.close();

        Scanner input = new Scanner(file);
        int tot = 0;
        while (input.hasNext()) {
            tot += input.nextInt();
        }

        System.out.println("Total: " + tot  + "\nAverage: " + tot/100.0);
    }
}
