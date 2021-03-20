/**
 *  Programming exercise - Programming Exercise 12.31
 *
 *  (Baby name popularity ranking) The popularity ranking of baby names from
 *  years 2001 to 2010 is downloaded from www.ssa.gov/oact/babynames and stored
 *  in files named babynameranking2001.txt, babynameranking2002.txt, . . . ,
 *  babynameranking2010.txt. Each file contains one thousand lines. Each line
 *  contains a ranking, a boy’s name, number for the boy’s name, a girl’s name,
 *  and number for the girl’s name. For example, the first two lines in the file
 *  babynameranking2010.txt are as follows:
 *
 *  1 Jacob 21,875 Isabella 22,731
 *  2 Ethan 17,866 Sophia 20,477
 *
 *  So, the boy’s name Jacob and girl’s name Isabella are ranked #1 and the boy’s
 *  name Ethan and girl’s name Sophia are ranked #2. 21,875 boys are named
 *  Jacob and 22,731 girls are named Isabella. Write a program that prompts the
 *  user to enter the year, gender, and followed by a name, and displays the ranking
 *  of the name for the year. Here is a sample run:
 *
 *  Enter the year: 2010
 *  Enter the gender: M
 *  Enter the name: Javier
 *  Javier is ranked #190 in year 2010
 *
 *  Note: This program has written with using this data: https://www.ssa.gov/oact/babynames/names.zip
 *  So "Exercise12_31.java" have to run within same directory of the "names" folder.
 * 
 *  @author Mustafa Arinmis
 *  @since 19.12.2020
 * */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;


public class Exercise12_31 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the year: ");
        int year = input.nextInt();
        System.out.print("Enter the gender: ");
        String gender = input.next();
        System.out.print("Enter the name: ");
        String name = input.next();

        // check for is inputs are correct
        if(year > 2019 || year < 1880) {
            System.out.println(year + " data does not exist. Data range: [2019, 1880]");
            System.exit(0);
        }
        if(!(gender.toLowerCase().equals("m") || gender.toLowerCase().equals("f"))) {
            System.out.println("Enter gender as 'M' for male, and 'F' for female");
            System.exit(0);
        }

        int rank = getNameStat(year, gender, name);
        if(rank == 1)
            System.out.println("Given name \"" + name + "\" is not in top ranks");
        System.out.printf("\n%s is ranked #%d in year %d\n",
                name, rank, year);

    }

    public static int getNameStat(int year, String gender, String name) {
        /* data pattern(which I could found):

            Data Pattern: Name,Female,Rank
                               ....
                               ....
            Data Pattern: Name,Males,Rank
                               ....
                               ....
         */

        gender = gender.toUpperCase();
        name = name.substring(0,1).toUpperCase() + name.substring(1); //formatting name
        File file = new File("./names/yob" + year + ".txt");
        try{
            Scanner input = new Scanner(file);
            if(gender.equals("F")) {
                String[] line;
                do{
                    line = input.nextLine().split(",");

                    if(line[1].equals("M")) //if pass all females
                        return -1;          // that means given name doesn't exist

                    if( line[0].equals(name))  //if name founded return rank
                        return Integer.valueOf(line[2]);

                }while(input.hasNext());
            }
            else{ //that mean we are looking for males
                String[] line;
                do{
                    line = input.nextLine().split(",");

                    if(line[1].equals("F")) //skip girls
                        continue;

                    if( line[0].equals(name))  //if name founded return rank
                        return Integer.valueOf(line[2]);
                }while(input.hasNext());
            }
        }catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return -1;
    }
}
