package Problems.medium;

public class UniquePath {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePathsBU(3, 7));
    }

    static int[][] dp;

    public static int uniquePaths(int m, int n) {
        dp = new int[m][n];
        m--;
        n--;
        return ways(m, n, 0, 0);
    }

    public static int uniquePathsBU(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                dp[i][j] += j >= 1 ? dp[i][j - 1] : 0;
                dp[i][j] += i >= 1 ? dp[i - 1][j] : 0;
            }
        }
        return dp[m - 1][n - 1];
    }

    private static int ways(int m, int n, int x, int y) {
        if (x > m || y > n) return 0;
        if (x == m && y == n) return 1;
        if (dp[x][y] != 0) return dp[x][y];
        return dp[x][y] = ways(m, n, x + 1, y) + ways(m, n, x, y + 1);
    }
}
