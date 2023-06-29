package org.code.easy;

public class ClimbStair {

    public static void main(String[] args) {
        System.out.println(climbStairs(10));
    }

    public static int climbStairs(int n) {
        int[] mem = new int[n + 1];
        return trav(n, 0, mem);
    }

    private static int trav(int n, int idx, int[] mem) {
        if (idx == n) return 1;
        if (idx > n) return 0;
        if (mem[idx] != 0) return mem[idx];
        return mem[idx] = trav(n, idx + 1, mem) + trav(n, idx + 2, mem);
    }
}
