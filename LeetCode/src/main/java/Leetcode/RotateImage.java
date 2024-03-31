package Leetcode;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);

        for (int[] x : matrix) {
            for (int y : x) System.out.print(y + " ");
            System.out.println();
        }

    }

    static void rotate(int[][] matrix) {
        transpose(matrix);
        reverseCol(matrix);
    }

    static void reverseCol(int[][] matrix) {
        for (int idx = 0; idx < matrix.length; idx++) {
            int sI = 0, eI = matrix[idx].length - 1;
            while (sI < eI) {
                int sP = matrix[idx][sI];
                matrix[idx][sI] = matrix[idx][eI];
                matrix[idx][eI] = sP;
                sI++;
                eI--;
            }
        }
    }

    static void transpose(int[][] matrix) {
        for (int idx = 0; idx < matrix.length; idx++) {
            for (int idy = 0; idy < matrix[idx].length; idy++) {
                if (idx > idy) continue;
                int sM = matrix[idx][idy];
                matrix[idx][idy] = matrix[idy][idx];
                matrix[idy][idx] = sM;
            }
        }
    }
}
