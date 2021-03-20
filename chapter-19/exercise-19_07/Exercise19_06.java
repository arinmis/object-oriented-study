/**
 *  Programming Exercise 19.07
 *
 *  (Generic binary search) Implement the following method using binary search.
 *  public static <E extends Comparable<E>>
 *  int binarySearch(E[] list, E key)
 *
 *  public static <E extends Comparable<E>> E max(E[][] list)
 *
 *  @author Mustafa Arinmis
 *  @since 31.12.2020
 * */


public class Exercise19_07{
    public static void main(String[] args) {
        //test program
        Integer[] list = new Integer[5];
        list[0] = 1;
        list[1] = 25;
        list[2] = 33;
        list[3] = 45;
        list[4] = 98;

        System.out.println(binarySearch(list, 3 ));
        System.out.println(binarySearch(list, 33 ));
    }

    public static <E extends Comparable<E>> int binarySearch(E[] list, E key) {
        int start = 0;
        int end = list.length - 1;
        int mid;
        while(start <= end) {
            mid = (start + end) / 2;
            if(list[mid].compareTo(key) == 0)
                return mid;
            else if(list[mid].compareTo(key) == -1) {
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return -1;
    }
}
