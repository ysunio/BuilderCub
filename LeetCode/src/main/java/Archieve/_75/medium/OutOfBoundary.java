package Archieve._75.medium;

import java.util.Arrays;

public class OutOfBoundary {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        long[][][] visited = new long[m][n][maxMove + 1];
        for (long[][] x : visited) for (long[] y : x) Arrays.fill(y, -1);
        return (int) (solve(m, n, maxMove, startRow, startColumn, visited) % 1000000007);
    }

    private long solve(int m, int n, int maxMove, int r, int c, long[][][] visited) {
        if (r < 0 || r >= m || c < 0 || c >= n) return 1;
        if (maxMove <= 0) return 0;
        if (visited[r][c][maxMove] != -1) return (visited[r][c][maxMove]);

        long v = 0;
        v += (solve(m, n, maxMove - 1, r + 1, c, visited));
        v += (solve(m, n, maxMove - 1, r - 1, c, visited));
        v += (solve(m, n, maxMove - 1, r, c + 1, visited));
        v += (solve(m, n, maxMove - 1, r, c - 1, visited));

        // visited[r][c][maxMove] = (int) (value % 1000000007);
        return visited[r][c][maxMove] = v % 1000000007;
    }
}
