/**
 *  Programming exercise - Programming Exercise 12.29
 *
 *  (Rename files) Suppose you have a lot of files in a directory named Exercisei_j,
 *  here i and j are digits. Write a program that pads a 0 before j if j is a single
 *  digit. For example, a file named Exercise2_1 in a directory will be renamed to
 *  Exercise2_01. In Java, when you pass the symbol * from the command line,
 *  it refers to all files in the directory (see Supplement III.V). Use the following
 *  command to run your program.
 *
 *  java Exercise12_29 *
 *
 *  @author Mustafa Arinmis
 *  @since 11.12.2020
 * */

import java.io.File;


public class Exercise12_29 {
    public static void main(String[] args) {

        File file;
        for (int i = 0; i < args.length; i++) {
            file = new File(args[i]);
            String[] names = splitName(file.getName());
            String newName = editName(names[0] );
            file.renameTo(new File(newName  + names[1]));
        }
    }

    public static String editName(String str) {
        StringBuilder idOfFile = new StringBuilder(str);

        if(idOfFile.length() == "Exercise12_34".length()) {
            return str;
        }

        if(idOfFile.charAt(idOfFile.length() - 2) == '_') // if right side of the underscore has one digit
            idOfFile.insert(idOfFile.length() - 1, '0');

        return idOfFile.toString();
    }
    public static  String[] splitName(String fileName) {
        // separate name as name and extension
        int index = fileName.indexOf('.');
        String[] names = {fileName.substring(0, index), fileName.substring(index) };
        return names;
    }
}
