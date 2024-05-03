package Leetcode;

public class NumberOfIsland {
    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '1', '0'}
        }));
    }

    public static int numIslands(char[][] grid) {
        int totalLands = 0;
        for (int x = 0; x < grid.length; x++)
            for (int y = 0; y < grid[x].length; y++)
                if (grid[x][y] == '1') {
                    totalLands++;
                    dfs(grid, x, y);
                }
        return totalLands;
    }

    private static void dfs(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) return;
        if (grid[x][y] == '1') {
            grid[x][y] = '0';
            dfs(grid, x + 1, y);
            dfs(grid, x - 1, y);
            dfs(grid, x, y + 1);
            dfs(grid, x, y - 1);
        }
    }
}
