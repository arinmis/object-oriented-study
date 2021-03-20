/**
 *  Programming Exercise 19.04
 *
 *  (Distinct elements in ArrayList ) Write the following method that returns a new
 *  ArrayList . The new list contains the non-duplicate elements from the original list.
 *  public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list)
 *
 *  @author Mustafa Arinmis
 *  @since 31.12.2020
 * */


public class Exercise19_04{
    public static void main(String[] args) {
        //test program
        String[] names = new String[3];
        names[0] = "Ali";
        names[1] = "Ayse";
        names[2] = "Mustafa";

        System.out.println(linearSearch(names, "Mustafa"));
        System.out.println(linearSearch(names, "Ahmet"));

    }

    /* if key exist in the list return it's index els return -1 */
    public static <E extends Comparable<E>> int linearSearch(E[] list, E key) {
        for(int i=0; i<list.length; i++) {
            if(list[i].compareTo(key) == 0)
                return i;
        }
        return -1;
    }
}
