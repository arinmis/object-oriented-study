import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;



/**
 * Programming exercise - Programming Exercise 12.16
 *
 * (Replace text) Listing 12.16, ReplaceText.java, gives a program that replaces
 * text in a source file and saves the change into a new file. Revise the program to
 * save the change into the original file
 *
 *  @author Mustafa Arinmis
 *  @since 15.11.2020
 * */


public class ReplaceText {
    public static void main(String[] args) throws IOException {

        // Check command line parameter usage
        if (args.length != 3) {
            System.out.println(
                    "Usage: java ReplaceText sourceFile  oldStr newStr");
            System.exit(1);
        }
        // Check if source file exists
        File sourceFile = new File(args[0]);
        if (!sourceFile.exists()) {
            System.out.println("Source file " + args[0] + " does not exist");
            System.exit(2);
        }

        ArrayList<String> lines = new ArrayList<String>();
        try (
                // Create input
                Scanner input = new Scanner(sourceFile);
        ) {
            while (input.hasNext()) {
                lines.add(input.nextLine());
            }
        }

        try (
                //Create output
                PrintWriter output = new PrintWriter(sourceFile);
        ) {
            for(int i=0; i<lines.size(); i++) {
                output.println(lines.get(i).replace(args[1], args[2]));
            }
        }
    }
}
