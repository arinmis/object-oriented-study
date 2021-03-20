/**
 *  Programming exercise - Programming Exercise 12.32
 *
 *  (Search Web) Modify Listing 12.18 WebCrawler.java to search for the word
 *  Computer Programming starting from the URL http://cs.armstrong.edu/liang .
 *  Your program terminates once the word is found. Display the URL for the page
 *  that contains the word.
 *
 *  @author Mustafa Arinmis
 *  @since 19.12.2020
 * */


import java.util.ArrayList;
import java.util.Scanner;

public class Exercise12_32 {
    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("Enter a URL: ");
        String url = input.nextLine();
        crawler(url); // Traverse the Web from the a starting url
    }
    public static void crawler(String startingURL) {
        ArrayList<String> listOfPendingURLs = new ArrayList<>();
        ArrayList<String> listOfTraversedURLs = new ArrayList<>();
        listOfPendingURLs.add(startingURL);
        while (!listOfPendingURLs.isEmpty() &&
                listOfTraversedURLs.size() <= 100) {
            String urlString = listOfPendingURLs.remove(0);
            if (!listOfTraversedURLs.contains(urlString)) {
                listOfTraversedURLs.add(urlString);
                for (String s: getSubURLs(urlString)) {
                    if (!listOfTraversedURLs.contains(s))
                        listOfPendingURLs.add(s);
                }
            }
        }
    }

    public static ArrayList<String> getSubURLs(String urlString) {
        ArrayList<String> list = new ArrayList<>();
        try {
            java.net.URL url = new java.net.URL(urlString);
            Scanner input = new Scanner(url.openStream());
            int current = 0;
            boolean isPrinted = false;
            while (input.hasNext()) {
                String line = input.nextLine();
                if(line.contains("Programming".toLowerCase()) && !isPrinted) { //print URL
                    System.out.println("Computer Programming founded in: " + urlString);
                    isPrinted = true;
                }
                current = line.indexOf("http:", current);
                while (current > 0) {
                    int endIndex = line.indexOf("\"", current);
                    if (endIndex > 0) { // Ensure that a correct URL is found
                        list.add(line.substring(current, endIndex));
                        current = line.indexOf("http:", endIndex);
                    }
                    else
                        current = -1;
                }
            }
        }
        catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return list;
    }
}