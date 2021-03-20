import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *  Programming exercise - Programming Exercise 12.11
 *  Program will delete given word in given file name in
 *  commandline
 *
 *  @author Mustafa Arinmis
 *  @since 05.11.2020
 * */

public class Main {
    public static void main(String[] args) throws IOException {
        String abandonWord = args[0];
        String fileName = args[1];

        File file = new File(fileName);

        if(!file.exists()) {
            System.out.println("file does not exist");
            System.exit(0);
        }
        Scanner input = new Scanner(file);


        ArrayList<String> words = new ArrayList<String>();
        while(input.hasNext()) {
            String temp = input.next();
            if(!temp.equals(abandonWord))
                words.add(temp);
        }

        PrintWriter output = new PrintWriter(fileName);
        for(int i=0; i<words.size(); i++)
                output.print(words.get(i) + " ");

        output.close();

    }
}
