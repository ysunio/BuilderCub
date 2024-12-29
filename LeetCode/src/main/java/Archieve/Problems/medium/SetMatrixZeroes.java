package Archieve.Problems.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(matrix);

        for (int[] x : matrix) {
            Arrays.stream(x).forEach(System.out::print);
            System.out.println();
        }
    }

    static class Coord {
        int x;
        int y;

        Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void setZeroes(int[][] matrix) {
        Queue<Coord> queue = new LinkedList<>();

        for (int idx = 0; idx < matrix.length; idx++) {
            for (int idy = 0; idy < matrix[0].length; idy++)
                if (matrix[idx][idy] == 0) queue.add(new Coord(idx, idy));
        }

        while (!queue.isEmpty()) {
            Coord currentCoord = queue.poll();
            makeRowColZero(matrix, currentCoord);
        }
    }

    private static void makeRowColZero(int[][] matrix, Coord coord) {
        int x = coord.x;
        int y = coord.y;

        int lenRow = matrix.length;
        int lenCol = matrix[0].length;

        for (int idx = 0; idx < lenRow; idx++) matrix[idx][y] = 0;
        for (int idx = 0; idx < lenCol; idx++) matrix[x][idx] = 0;
    }
}
