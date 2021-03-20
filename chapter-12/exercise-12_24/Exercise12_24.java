/**
 *  Programming exercise - Programming Exercise 12.24
 *
 *  (Create large dataset) Create a data file with 1,000 lines. Each line in the file
 *  consists of a faculty member’s first name, last name, rank, and salary. The
 *  faculty member’s first name and last name for the ith line are FirstNamei and
 *  LastNamei. The rank is randomly generated as assistant, associate, and full.
 *  The salary is randomly generated as a number with two digits after the decimal
 *  point. The salary for an assistant professor should be in the range from 50,000
 *  to 80,000, for associate professor from 60,000 to 110,000, and for full professor
 *  from 75,000 to 130,000. Save the file in Salary.txt. Here are some sample data:
 *
 *  FirstName1 LastName1 assistant 60055.95
 *  FirstName2 LastName2 associate 81112.45
 *  . . .
 *  FirstName1000 LastName1000 full 92255.21
 *
 *  @author Mustafa Arinmis
 *  @since 10.12.2020
 * */


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;



public class Exercise12_24 {
    public static void main(String[] args)  {
        File file = new File("Salary.txt");

        try(    // file automatically will  be created by print writer
                PrintWriter output = new PrintWriter(file);
           )
        {
            for(int i=0; i<10000000; i++) {
                String rank = createRank();
                output.println(createName(i + 1) + " "+ rank + " "+ createSalary(rank) );
            }
        }catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    public static String createName(int i) {
        return "FirstName" + i + " LastName" + i;
    }

    public static String createRank() {
        String[] ranks = {"assistant", "associate", "full"};

        return ranks[(int)(Math.random() * 3)];
    }

    public static String createSalary(String rank) {
        Random random = new Random();
        if(rank.equals("assistant")) { //range 50,000 - 80,000
            return (random.nextInt(30000) + 50000) + "." + random.nextInt(100);
        }
        else if(rank.equals("associate")) { //range 60,000 - 110,000
            return (random.nextInt(50000) + 60000) + "." + random.nextInt(100);
        }
        else //range 75,000 - 130,000
            return (random.nextInt(55000) + 75000) + "." + random.nextInt(100);
    }
}

