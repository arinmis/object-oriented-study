import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *  Programming exercise - Programming Exercise 12.12
 *
 *  (Reformat Java source code) Write a program that converts the Java source
 *  code from the next-line brace style to the end-of-line brace style.
 *
 *  @author Mustafa Arinmis
 *  @since 05.11.2020
 * */

public class Endline{
    public static void main(String[] args) {

        if(args.length != 1) {
            System.out.println("Usage: java Endline Test.java");
            System.exit(0);
        }

        //Creating file object
        File file = new File(args[0]);
        
        ArrayList<String> codeLines = new ArrayList<String>();
        // Reading java code and storing all lines in ArrayList
        try{
            Scanner input = new Scanner(file);

            while (input.hasNext()) {
                codeLines.add(input.nextLine());
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("Given file not found: " + args[0]);

        }
    
        // writing all all line according to end-of-line brace style
        try{
            PrintWriter output = new PrintWriter(args[0]);

            for(int i=0; i<codeLines.size() - 1; i++) {
                if(codeLines.get(i+1).contains("{") && !codeLines.get(i).contains("{") ) {
                    output.print(codeLines.get(i));
                }
                else if (codeLines.get(i).contains("{")){
                    output.println(" " + codeLines.get(i).trim());
                }
                else
                    output.println(codeLines.get(i));
            }
            output.println(codeLines.get(codeLines.size() - 1));
            output.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println("Given file not found: " + args[0]);
        }

    }
}
