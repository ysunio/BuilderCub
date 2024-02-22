package _75.easy;

public class FindTown {
    public int findJudge(int n, int[][] trust) {
        if (n == 1) return n;


        int[] eligibaleJudge = new int[n + 1];

        for (int x[] : trust) {
            eligibaleJudge[x[0]] = -1;
            if (eligibaleJudge[x[1]] != -1) eligibaleJudge[x[1]]++;
        }

        for (int idx = 0; idx < eligibaleJudge.length; idx++)
            if (eligibaleJudge[idx] == n - 1) return idx;

        return -1;
    }
}
