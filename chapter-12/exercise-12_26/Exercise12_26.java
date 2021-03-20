/**
 *  Programming exercise - Programming Exercise 12.26
 *
 *  (Create a directory) Write a program that prompts the user to enter a directory
 *  name and creates a directory using the File ’s mkdirs method. The program
 *  displays the message “Directory created successfully” if a directory is created
 *  or “Directory already exists” if the directory already exists.
 *
 *  @author Mustafa Arinmis
 *  @since 11.12.2020
 * */

import java.io.File;
import java.util.Scanner;


public class Exercise12_26 {
    public static void main(String[] args) {

        System.out.println("Enter directory that will be created: ");
        String dir = new Scanner(System.in).next();
        File file = new File(dir);

        if(file.exists())
            System.out.println("Directory already exists" );
        else if(file.mkdirs()){
            System.out.println("Directory created successfully");
        }
        else{
            System.out.println("Invalid directory");
        }
    }
}

