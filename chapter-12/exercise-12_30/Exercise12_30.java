/**
 *  Programming exercise - Programming Exercise 12.30
 *
 *  (Occurrences of each letter) Write a program that prompts the user to enter
 *  a file name and displays the occurrences of each letter in the file. Letters are
 *  case-insensitive. Here is a sample run:
 *
 *  @author Mustafa Arinmis
 *  @since 19.12.2020
 * */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;


public class Exercise12_30 {
    public static void main(String[] args) {
        //read file name from console
        System.out.println("Enter a filename:");
        String fileName = new Scanner(System.in).next();

        File textFile = new File(fileName);
        HashMap<Character, Integer> statsHashMap = new HashMap<>(); // store statistics in hash map

        try{ // reading text
            Scanner input = new Scanner(textFile);
            while(input.hasNext()) {
                countChr(input.next(), statsHashMap);
            }
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
        // printing statistics
        for (HashMap.Entry<Character, Integer> entry : statsHashMap.entrySet()) {
            System.out.printf("Number of %c's: %d\n", entry.getKey(), entry.getValue());
        }
    }
    public static void countChr(String word, HashMap<Character, Integer> hashMap) {
        word = word.toLowerCase();
        for(int i=0; i<word.length(); i++) {
            char chr = word.charAt(i);
            if(hashMap.containsKey(chr)) { //if char already exist increment the char's value by 1
                hashMap.put(chr, hashMap.get(chr) + 1);
            }
            else
                hashMap.put(chr, 1);
        }
    }
}
