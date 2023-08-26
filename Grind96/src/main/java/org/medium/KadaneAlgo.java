package org.medium;

public class KadaneAlgo {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-1, -2, 4, 5, 6, 4, 3, 2, 4,}));
    }

    static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int tSum = 0;
        for (int num : nums) {
            tSum += num;
            max = Math.max(max, tSum);
            if (tSum < 0)
                tSum = 0;
        }
        return max;
    }
}
