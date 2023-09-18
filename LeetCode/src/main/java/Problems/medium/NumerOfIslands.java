package Problems.medium;

public class NumerOfIslands {

    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '1', '0'}
        }));
    }

    public static int numIslands(char[][] grid) {
        int totalIsland = 0;
        for (int x = 0; x < grid.length; x++)
            for (int y = 0; y < grid[0].length; y++)
                if (grid[x][y] == '1') {
                    df(grid, x, y);
                    totalIsland++;
                }

        return totalIsland;
    }

    private static void df(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return;
        if (grid[x][y] == '0') return;
        grid[x][y] = '0';
        df(grid, x + 1, y);
        df(grid, x, y + 1);
        df(grid, x - 1, y);
        df(grid, x, y - 1);
    }
}
