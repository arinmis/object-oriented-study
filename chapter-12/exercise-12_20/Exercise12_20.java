/**
 *  Programming exercise - Programming Exercise 12.20
 *
 *  (Remove package statement) Suppose you have Java source files under the
 *  directories chapter1 , chapter2 , . . . , chapter34 . Write a program to
 *  remove the statement package chapteri; in the first line for each Java
 *  source file under the directory chapteri . Suppose chapter1 , chapter2 ,
 *  . . . , chapter34 are under the root directory srcRootDirectory . The root
 *  directory and chapteri directory may contain other folders and files. Use
 *  the following command to run the program:
 * 
 *  java Exercise12_20 srcRootDirectory
 *  
 *  @author Mustafa Arinmis
 *  @since 09.12.2020
 * */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise12_20 {
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
                        delPackageLine(listOFiles[j], directory);
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

    public static void delPackageLine(File file, String packageName) throws IOException {
        ArrayList<String> lines = new ArrayList<>(); // to store lines of file
        Scanner input = new Scanner(file); // file's lines
        boolean isFirst = true;
        while(input.hasNext()) {
            if(isFirst) {
                input.nextLine(); // since package statement in the first line, it will be skipped
                isFirst = false; 
            }
            lines.add(input.nextLine()); // store each line in arraylist
        }

        try(PrintWriter output = new PrintWriter(file)) { //printwriter will erase all line from the file
            for (String line : lines)
                output.println(line);
        }


        System.out.println("package statement deleted from the file "  + file );
    }

}