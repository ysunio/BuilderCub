package _75.medium;

public class MinFallingPath {
    public int minFallingPathSum(int[][] matrix) {
        int[][] shortestFall = new int[matrix.length][matrix[0].length];
        shortestFall[0] = matrix[0];

        // O(N-1 * M) - N : Row / M : Column
        for (int rowCounter = 1; rowCounter < matrix.length; rowCounter++) {
            for (int colCounter = 0; colCounter < matrix[0].length; colCounter++) {
                shortestFall[rowCounter][colCounter] = matrix[rowCounter][colCounter] + findMinConsecutive(shortestFall, rowCounter - 1, colCounter);
            }
        }

        // O(N) - N : Row
        int minPathAtFall = Integer.MAX_VALUE;
        for (int idx = 0; idx < shortestFall[0].length; idx++) {
            minPathAtFall = Math.min(minPathAtFall, shortestFall[shortestFall.length - 1][idx]);
        }
        return minPathAtFall;
    }

    // O(3) - Constant
    private int findMinConsecutive(int[][] shortestFall, int rowCounter, int colCounter) {
        int minValue = shortestFall[rowCounter][colCounter];
        if (colCounter > 0) minValue = Math.min(minValue, shortestFall[rowCounter][colCounter - 1]);
        if (colCounter < shortestFall.length - 1)
            minValue = Math.min(minValue, shortestFall[rowCounter][colCounter + 1]);
        return minValue;
    }
}
