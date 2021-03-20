import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Programming exercise - Programming Exercise 12.16
 *
 * (Add package statement) Suppose you have Java source fles under the direc-
 * tories chapter1 , chapter2 , . . . , chapter34 . Write a program to insert the
 * statement package chapteri; as the first line for each Java source file under
 * the directory chapteri . Suppose chapter1 , chapter2 , . . . , chapter34
 * are under the root directory srcRootDirectory . The root directory and
 * chapteri directory may contain other folders and files.
 *
 *  @author Mustafa Arinmis
 *  @since 15.11.2020
 * */



public class Main {
    public static void main(String[] main) {

        int count = 0;
        int n=64;
        for( int i=1; i<=n; i *= 2)
            for(int j=1; j <=i; j *= 2 ){
                System.out.println(i + " - " + j);
                count++;
            }

            System.out.println(count);
    }







    /*//this code will create 'srcRootDirectory' to given path
    // and fill that folder given amount of given java file
    public static void createJavaFiles(String path, File file) throws IOException {
        path +=  "/srcRootDirectory/";


        File rootFolder = new File(path);


        if(rootFolder.mkdir())
            System.out.println("Root folder created");
        else
            System.out.println("Root folder couldn't created");


        for(int i=0; i<34; i++) {
            String tempPath = path + "/chapter" + i;
            File tempFolder = new File(tempPath);
            if(tempFolder.mkdir())
                System.out.println("src folder created");
            else
                System.out.println("src folder does not created");

            for(int k=0; k<(int)(Math.random() * 10) + 1; k++) {

                File tempFile = new File(tempPath + "/Project" + (k+1) + ".java");

                if(tempFile.createNewFile()) {
                    Scanner input = new Scanner(file);
                    PrintWriter output = new PrintWriter(tempFile);
                    while (input.hasNext())
                        output.println(input.nextLine());

                    System.out.println("Created" + tempFile.getPath());
                    output.close();
                }
            }

        }
    }
*/

}