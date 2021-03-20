import java.util.Scanner;

/**
 *  Programming exercise - Programming Exercise 12.19
 *
 *  (Count words) Write a program that counts the number of words in President
 *  Abraham Lincoln’s Gettysburg address from http://cs.armstrong.edu/liang/data/
 *  Lincoln.txt .
 * 
 *  Note: link was broken, I used this text -> https://www.d.umn.edu/~rmaclin/gettysburg-address.html
 *  
 *  @author Mustafa Arinmis
 *  @since 09.12.2020
 * */
public class Main {
    public static void main(String[] args) {
        File file = new File("Lincoln.txt");
        int count = 0;

        try(Scanner input = new Scanner(file)) {
            while (input.hasNext()) {
                count++;
                input.next(); // pass the word
            }
        }catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println("Lincoln.txt contains " + count + " words");
    }
}