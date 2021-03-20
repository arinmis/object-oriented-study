/**
 *  Programming exercise - Programming Exercise 12.22
 *
 *  (Replace text) Revise Programming Exercise 12.16 to replace a string in a file
 *  with a new string for all files in the specified directory using the command:
 *
 *  java Exercise12_22 dir oldString newString
 *
 *  @author Mustafa Arinmis
 *  @since 10.12.2020
 * */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Exercise12_22 {
    public static void main(String[] args)  {

        // Check command line parameter usage
        if (args.length != 3) {
            System.out.println(
                    "Usage: java ReplaceText dir  oldStr newStr");
            System.exit(1);
        }
        // Check if source file exists
        File dir = new File(args[0]);
        if (!dir.exists()) {
            System.out.println("Source file " + args[0] + " does not exist");
            System.exit(2);
        }
        // list all file types of files in the given directory folder
        File files[] = dir.listFiles();
        for(File file : files)
            replaceTxt(file, args[1], args[2]);


    }

    public static void replaceTxt(File file, String targetText, String newText)  {
        ArrayList<String> lines = new ArrayList<String>();

        //read words from file and store in
        try (
                Scanner input = new Scanner(file);    // Create input
        ) {
            while (input.hasNext()) {
                lines.add(input.nextLine());
            }
        } catch (IOException ex) {
        ex.printStackTrace();
    }


        try (
                PrintWriter output = new PrintWriter(file);   //Create output
        ) {
            for(int i=0; i<lines.size(); i++) {
                output.println(lines.get(i).replace(targetText, newText));
            }
            System.out.println("In file " + file + targetText + " replaced with " + newText );
        }catch (IOException ex) {
            ex.printStackTrace();
        }


    }
}
