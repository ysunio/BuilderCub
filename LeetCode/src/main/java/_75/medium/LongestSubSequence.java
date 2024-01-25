package _75.medium;

import java.util.Arrays;

public class LongestSubSequence {
    public int longestCommonSubsequence(String A, String B) {
        int[][] db = new int[A.length()][B.length()];
        for (int[] x : db) Arrays.fill(x, -1);
        return solve(A, B, 0, 0, db);
    }

    private int solve(String A, String B, int aIdx, int bIdx, int[][] db) {
        if (aIdx >= A.length() || bIdx >= B.length()) return 0;
        if (db[aIdx][bIdx] != -1) return db[aIdx][bIdx];
        if (A.charAt(aIdx) == B.charAt(bIdx))
            return db[aIdx][bIdx] = 1 + solve(A, B, aIdx + 1, bIdx + 1, db);
        return db[aIdx][bIdx] = Math.max(solve(A, B, aIdx + 1, bIdx, db), solve(A, B, aIdx, bIdx + 1, db));
    }
}
