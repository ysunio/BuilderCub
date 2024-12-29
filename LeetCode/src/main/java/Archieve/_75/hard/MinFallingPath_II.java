package Archieve._75.hard;

public class MinFallingPath_II {
    public int minFallingPathSum(int[][] grid) {
        int[][] gStore = new int[grid.length][grid[0].length];
        gStore[0] = grid[0];

        for(int row = 1; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                gStore[row][col] = grid[row][col] + getMinAbove(gStore, row - 1, col);
            }
        }

        // O(N)
        int minPathSum = Integer.MAX_VALUE;
        for(int el : gStore[grid.length - 1]) minPathSum = Math.min(minPathSum, el);
        return minPathSum;
    }

    private int getMinAbove(int[][] grid, int row, int col){
        int minValue = Integer.MAX_VALUE;
        int[] aboveRow = grid[row];
        for(int idx = 0; idx < aboveRow.length; idx++){
            if(idx == col) continue;
            minValue = Math.min(minValue, aboveRow[idx]);
        }
        return minValue;
    }
}
