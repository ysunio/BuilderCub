package Archieve.Problems.medium;

public class MinimumPathSum {

    public static void main(String[] args) {
        System.out.println(minPathSum_Mem(new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        }));

        System.out.println(minPathSum(new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        }));
    }

    public static int minPathSum_Mem(int[][] grid) {
        int[][] mem = new int[grid.length][grid[0].length];
        return trace(grid, 0, 0, mem);
    }

    private static int trace(int[][] grid, int x, int y, int[][] mem){
        if(x >= grid.length || y >= grid[0].length) return Integer.MAX_VALUE;
        if(x == grid.length - 1 && y == grid[0].length - 1) return grid[x][y];
        if(mem[x][y] != 0) return mem[x][y];
        return mem[x][y] = grid[x][y] + Math.min(trace(grid, x + 1, y, mem), trace(grid, x, y + 1, mem));
    }
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for (int idx = 0; idx < m; idx++) {
            for (int idy = 0; idy < n; idy++) {
                if (idx == 0 && idy == 0) continue;
                int minIdxValue = idx >= 1 ? dp[idx - 1][idy] : Integer.MAX_VALUE;
                int minIdyValue = idy >= 1 ? dp[idx][idy - 1] : Integer.MAX_VALUE;
                dp[idx][idy] += grid[idx][idy] + Math.min(minIdxValue, minIdyValue);
            }
        }
        return dp[m - 1][n - 1];
    }
}
