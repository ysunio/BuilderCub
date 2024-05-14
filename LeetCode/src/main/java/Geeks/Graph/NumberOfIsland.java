package Geeks.Graph;

public class NumberOfIsland {
    public int numIslands(char[][] grid) {
        int numberOfIsland = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int idx = 0; idx < grid.length; idx++) {
            for (int idy = 0; idy < grid[0].length; idy++) {
                if (visited[idx][idy] || grid[idx][idy] == '0') continue;
                numberOfIsland++;
                dfs(grid, visited, idx, idy);
            }
        }

        return numberOfIsland;
    }

    private void dfs(char[][] grid, boolean[][] visited, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) return;
        if (visited[x][y] || grid[x][y] == '0') return;
        visited[x][y] = true;

        int[] xC = new int[]{-1, 0, 1};
        int[] yC = new int[]{-1, 0, 1};

        for (int idx = 0; idx < 3; idx++)
            for (int idy = 0; idy < 3; idy++)
                dfs(grid, visited, x + xC[idx], y + yC[idy]);
    }
}
