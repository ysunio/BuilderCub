package _75.hard;

import java.util.Arrays;

public class CherryPickII {
        public int cherryPickup(int[][] grid) {
            int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];
            for(int[][] x : dp) for(int[] y : x) Arrays.fill(y, -1);
            return cherryPickup(grid, 0, 0, grid[0].length - 1, dp);
        }

        private int cherryPickup(int[][] grid, int i, int j1, int j2, int[][][] dp){
            if(i >= grid.length || j1 < 0 || j2 < 0 || j1 >= grid[0].length || j2 >= grid[0].length) return 0;

            if(dp[i][j1][j2] != -1) return dp[i][j1][j2];

            int result = grid[i][j1] + grid[i][j2];

            int max = 0;
            for(int x = j1 - 1; x <= j1 + 1; x++){
                for(int y = j2 - 1; y <= j2 + 1; y++){
                    if(x >= y) continue;
                    max = Math.max(max, cherryPickup(grid, i + 1, x, y, dp));
                }
            }

            return dp[i][j1][j2] = result + max;
        }
}
