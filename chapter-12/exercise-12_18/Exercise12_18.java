/**
 * Programming exercise - Programming Exercise 12.18
 *
 * (Add package statement) Suppose you have Java source fles under the direc-
 * tories chapter1 , chapter2 , . . . , chapter34 . Write a program to insert the
 * statement package chapteri; as the first line for each Java source file under
 * the directory chapteri . Suppose chapter1 , chapter2 , . . . , chapter34
 * are under the root directory srcRootDirectory . The root directory and
 * chapteri directory may contain other folders and files.
 *
 *  @author Mustafa Arinmis
 *  @since 09.12.2020
 * */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise12_18 {
    public static void main(String[] args) {
        if(args.length != 1)
            System.out.println("Usage: " + "java Exercise12_18 srcRootDirectory");

        for(int i=0; i<34; i++) {
            String directory = "chapter" + (i + 1);
            try {
                File file = new File(args[0] + "/" + directory); // args[0] is "srcRootDirectory"
                if (file.exists()) {
                    MyFileNameFilter fileFilter = new MyFileNameFilter("java"); // extract java files
                    File[] listOFiles = file.listFiles(fileFilter);
                    for (int j = 0; j < listOFiles.length; j++) {
                        addPackageLine(listOFiles[j], directory);
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    public static class MyFileNameFilter implements FilenameFilter {

        private String extension;

        public MyFileNameFilter(String extension) {
            this.extension = extension.toLowerCase();
        }

        @Override
        public boolean accept(File dir, String name) {
            return name.toLowerCase().endsWith(extension);
        }

    }

    public static void addPackageLine(File file, String packageName) throws IOException {
        String temp = "package " + packageName + ";";
        ArrayList<String> lines = new ArrayList<>(); // to store lines of file
        Scanner input = new Scanner(file); // file's lines
        while(input.hasNext()) {
            lines.add(input.nextLine()); // store each line in arraylist
        }

        try(PrintWriter output = new PrintWriter(file)) { //printwriter will erase all line from the file
            output.println(temp + "\n\n"); // add package name top of the file
            for (String line : lines)
                output.println(line);
        }


        System.out.println("\"" + temp + "\" added to top of the file "  + file );
    }

}