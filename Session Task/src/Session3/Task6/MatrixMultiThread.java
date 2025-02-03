package Session3.Task6;

import java.util.Scanner;

class MatrixMulti extends Thread {

    int[][] matrix1; // define the matrix1
    int[][] matrix2; // define the matrix2
    int[][] result;  //create a result matrix

    int row;

    MatrixMulti(int[][] matrix1, int[][] matrix2, int[][] result, int row) {  // set the value
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.result = result;
        this.row = row;
    }

    // override the run method
    public void run() {
        for (int j = 0; j < matrix2[0].length; j++) {       // second matrix colum
            int sum = 0;
            for (int k = 0; k < matrix1[0].length; k++) {
                sum += matrix1[row][k] * matrix2[k][j];      // multiplication method in matrix
            }
            result[row][j] = sum;
        }
    }

}

public class MatrixMultiThread {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First matrix row : ");
        int matrix1_row = sc.nextInt();
        System.out.println("Enter First matrix column : ");
        int matrix1_column = sc.nextInt();
        System.out.println("Enter second matrix row : ");
        int matrix2_row = sc.nextInt();
        System.out.println("Enter second matrix column : ");
        int matrix2_column = sc.nextInt();
        int[][] matrix1;
        int[][] matrix2;
        int[][] result = new int[matrix1_row][matrix2_column];

        matrix1 = new int[matrix1_row][matrix1_column];
        matrix2 = new int[matrix2_row][matrix2_column];


        if (matrix1_column != matrix2_row) { // check matrix multiplication is possible or not
            System.out.println("Matrix multiplication is not possible ");
        } else {
            System.out.println("Enter elements of the first matrix:");   // Take user input for matrix 1
            for (int i = 0; i < matrix1_row; i++) {
                for (int j = 0; j < matrix1_column; j++) {
                    matrix1[i][j] = sc.nextInt();
                }
            }

            System.out.println("Enter elements of the second matrix:");  // Take user input for matrix 2
            for (int i = 0; i < matrix2_row; i++) {
                for (int j = 0; j < matrix2_column; j++) {
                    matrix2[i][j] = sc.nextInt();
                }
            }
            MatrixMulti[] threads = new MatrixMulti[matrix1_row];  // Thread array for all row
            for (int i = 0; i < matrix1_row; i++) {
                threads[i] = new MatrixMulti(matrix1, matrix2, result, i);   // Passing argument
                threads[i].start();       // Thread Start
            }
            for (int i = 0; i < matrix1_row; i++) {
                try {
                    threads[i].join();      // Thread join
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }


            for (int[] temparr : result) {     // print result array
                for (int k : temparr) {        // Get every row
                    System.out.print(k + " "); // print every element
                }
                System.out.println();
            }
        }
    }
}