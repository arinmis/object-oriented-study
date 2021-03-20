import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Programming exercise - Programming Exercise 12.18
 *
 * this support program has written to create needed 34 folder to programming exercise 12.16
 * program call it will create folder 34 folder which include random number of "java" file
 * java files are copy of given java as commandline args and named "Projct1.java", "Projct2.java"
 * and so on.
 *
 *  @author Mustafa Arinmis
 *  @since 09.12.2020
 * */
public class CreateSrc {
    public static void main(String[] args) throws IOException {
        if(args.length != 2)
            System.out.println("Usage: java CreateSrc copyTarget targetDirectory ");
        File file = new File(args[0]);
        createJavaFiles(args[1], file);   }

    //this code will create 'srcRootDirectory' to given path
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


}