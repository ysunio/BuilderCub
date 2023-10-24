package org.ys;

/*
    Expectations -
        1. Find the 2nd Highest Element
        2. Expected to Follow TDD (Test First)
        3. Clean Code
        4. Optimal Solution
*/
public class SecondHighestIndexTDD {
    public static void main(String[] args) {
        System.out.println(f(null) == -1);
        System.out.println(f(new int[]{}) == -1);
        System.out.println(f(new int[]{1, 1}) == -1);
        System.out.println(f(new int[]{1, 4, 3}) == 2);
        System.out.println(f(new int[]{4, 3, 1}) == 1);
        System.out.println(f(new int[]{1, 2, 3, 4, 5}) == 3);
        System.out.println(f(new int[]{5, 4, 3, 2, 1}) == 1);
        System.out.println(f(new int[]{1, 2, 1, 2}) == 0);
        System.out.println(f(new int[]{3, 3, 1, 2}) == 3);
        System.out.println(f(new int[]{1, 2, 3, 3}) == 1);
    }

    static int f(int[] A) {
        if (A == null || A.length < 2) return -1;

        int firstIndex = 0;
        int secondIndex = 1;

        if (A[secondIndex] > A[firstIndex]) {
            secondIndex = 0;
            firstIndex = 1;
        }

        for (int idx = 2; idx < A.length; idx++) {

            if (A[idx] > A[firstIndex]) {
                secondIndex = firstIndex;
                firstIndex = idx;
            } else if (A[idx] > A[secondIndex] && (A[idx] != A[firstIndex])) {
                secondIndex = idx;
            } else if (A[idx] < A[secondIndex] && A[firstIndex] == A[secondIndex]) {
                secondIndex = idx;
            }
        }

        if (A[firstIndex] == A[secondIndex]) return -1;

        return secondIndex;
    }
}