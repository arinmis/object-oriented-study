import java.util.*;

/**
 *
 *  Introduction to Java Programming - Programming Exercise 11.9
 *  
 * Problem statement: (Largest rows and columns) Write a program that randomly fills in 0 s and 1 s
 * into an n-by-n matrix, prints the matrix, and finds the rows and columns with the
 * most 1 s. (Hint: Use two ArrayList s to store the row and column indices with
 * the most 1 s.) 
 *
 *
 *  @author Mustafa Arinmis
 *  @since 22.08.2020
 *
 * */


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter dimention of matrix: ");
        int n = input.nextInt();

        int[][] matrix = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) {
                matrix[i][j] = (int)(Math.random() * 2);
            }
        }

        int[] columnsSums = sum('c', matrix);
        int[] rowsSums = sum('r', matrix);

        printM(matrix);

        ArrayList<Integer> maxRowIndex = new ArrayList<>();
        ArrayList<Integer> maxColumnIndex = new ArrayList<>();

        int maxCol = -1;
        int maxRow = -1;

        for(int i=0; i<n; i++ ) {
            maxCol = Math.max(maxCol, columnsSums[i]);
            maxRow = Math.max(maxRow, rowsSums[i]);
        }

        for(int i=0; i<n; i++ ) {
            if(columnsSums[i] == maxCol)
                    maxColumnIndex.add(i);

            if(rowsSums[i] == maxRow) {
                maxRowIndex.add(i);
            }
        }

        System.out.println("The largest row index: " + maxRowIndex);
        System.out.println("The largest column index: " + maxColumnIndex);

    }
    // There is two mod row and column
    public static int[] sum(char chr, int[][] matrix ) {


        if(chr == 'r') {
            int[] rowSum = new int[matrix.length];
            for(int i=0; i<matrix.length; i++) {
                for(int j=0; j<matrix[0].length; j++) {
                    rowSum[i] += matrix[i][j];
                }
            }

            return rowSum;

        }
        else{

            int[] columnSum = new int[matrix[0].length];

            for(int i=0; i<matrix.length; i++) {
                for(int j=0; j<matrix[0].length; j++) {
                    columnSum[i] += matrix[j][i];
                }
            }

            return columnSum;
        }
    }
    public static void printM(int[][] matrix) {
        for (int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}