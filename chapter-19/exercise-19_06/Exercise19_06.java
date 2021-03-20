import java.util.Arrays;

/**
 *  Programming Exercise 19.06
 *
 *  (Maximum element in a two-dimensional array) Write a generic method that
 *  returns the maximum element in a two-dimensional array.
 *
 *  public static <E extends Comparable<E>> E max(E[][] list)
 *
 *  @author Mustafa Arinmis
 *  @since 31.12.2020
 * */


public class Exercise19_06{
    public static void main(String[] args) {
        //test program
        Integer[][] numbers = new Integer[5][5];
        for (int i=0; i< numbers.length; i++) {
            for (int j = 0; j<numbers[0].length; j++)
                numbers[i][j] = i + j + 1;
        }

        printMatrix(numbers);
        System.out.println("Max element of an number array: " + max(numbers));

    }

    /* return max of the given 2d  array */
    public static <E extends Comparable<E>> E max(E[][] list) {
        E max = maxOfRow(list[0]);
        for(int i=1; i< list.length; i++) {
            E temp = maxOfRow(list[i]);
            if(temp.compareTo(max) == 1)
                max = temp;
        }
        return max;
    }

    /* return max of the given vector array */
    public static <E extends Comparable<E>> E maxOfRow(E[] list) {
        E max = list[0];
        for(int i=1; i<list.length; i++) {
            if(list[i].compareTo(max) == 1)
                max = list[i];
        }
        return max;
    }

    /* print 2d generic array */
    public static <E> void  printMatrix(E[][] list) {
        for(int i=0; i<list.length; i++ ) {
            for(int j=0; j<list[0].length; j++)
                System.out.print(list[i][j] + " ");
            System.out.println();
        }
    }


}
