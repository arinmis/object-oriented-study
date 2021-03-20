/**
 *  Programming exercise - Programming Exercise 12.27
 *
 *  (Replace words) Suppose you have a lot of files in a directory that contain
 *  words Exercisei_j, where i and j are digits. Write a program that pads a 0
 *  before i if i is a single digit and 0 before j if j is a single digit. For example,
 *  the word Exercise2_1 in a file will be replaced by Exercise02_01. In Java,
 *  when you pass the symbol * from the command line, it refers to all files in
 *  the directory (see Supplement III.V). Use the following command to run your
 *  program.
 *
 *  java Exercise12_27 *
 *
 *  @author Mustafa Arinmis
 *  @since 11.12.2020
 * */

import java.io.File;


public class Exercise12_27 {
    public static void main(String[] args) {

        File file;
        for (int i = 0; i < args.length; i++) {
            file = new File(args[i]);

            if (!file.exists()) {
                System.out.println(file + " doesn't exist");
                continue;
            }
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

        if(idOfFile.indexOf("_") == "Exercise1".length()) {// that mean id is in this "Exercise1_23" pattern
            idOfFile.insert("Exercise1".length() - 1, '0');
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
