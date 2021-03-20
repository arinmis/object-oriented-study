/**
 *  Programming exercise - Programming Exercise 12.25
 *
 *  (Process large dataset) A university posts its employees’ salaries at http://
 *  cs.armstrong.edu/liang/data/Salary.txt . Each line in the file consists of a faculty
 *  member’s first name, last name, rank, and salary (see Programming Exercise
 *  12.24). Write a program to display the total salary for assistant professors,
 *  associate professors, full professors, and all faculty, respectively, and display
 *  the average salary for assistant professors, associate professors, full professors,
 *  and all faculty, respectively.
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
import java.util.Scanner;


public class Exercise12_25 {
    public static void main(String[] args)  {
        File file = new File("Salary.txt");

        try(
                Scanner input = new Scanner(file);
           )
        { // to take average, we need total salary and person number for each kind of rank
            int numOfAssistant = 0;
            int numOfAssociate = 0;
            int numOfFull = 0;
            double assistantTotal = 0;
            double associateTotal = 0;
            double fullTotal = 0;
            while(input.hasNext()) {
                String row = input.nextLine(); // row pattern: "FirstName LastName rank salary"
                String[] columns = row.split(" ");
                String rank = columns[2];

                switch (rank) {
                    case "assistant":
                        assistantTotal += Double.valueOf(columns[3]);
                        numOfAssistant++;
                        break;
                    case "associate":
                        associateTotal += Double.valueOf(columns[3]);
                        numOfAssociate++;
                        break;
                    case "full":
                        fullTotal += Double.valueOf(columns[3]);
                        numOfFull++;
                        break;
                }
            }
                // display total and averages salary
                System.out.printf("Assistant's total salary is: %.2f\n", assistantTotal);
                System.out.printf("Assistant's average salary is: %.2f\n", assistantTotal/numOfAssistant);

                System.out.printf("Associate's total salary is: %.2f\n", associateTotal);
                System.out.printf("Associate's average salary is: %.2f\n", associateTotal/numOfAssociate);

                System.out.printf("Full's total salary is: %.2f\n", fullTotal);
                System.out.printf("Full's average salary is: %.2f\n", fullTotal/numOfFull);

                System.out.println(numOfAssistant + numOfAssociate + numOfFull);

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}

