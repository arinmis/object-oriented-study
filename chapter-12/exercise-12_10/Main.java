/**
 *
 *  Programming exercise - Programming Exercise 12.10
 *  
 *  @author Mustafa Arinmis
 *  @since 05.11.2020
 * */

public class Main {
    public static void main(String[] args) {
        
        try{                    //arrays size exceeds heap space
            Integer[] array = new Integer[100000000 * 100000000];
        }
        catch(OutOfMemoryError ex) {
        System.out.println("OutOfMomoryError has been handled");
    }
    }
}

