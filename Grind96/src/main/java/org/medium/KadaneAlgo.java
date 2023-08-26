package org.medium;

public class KadaneAlgo {
    int maxSubArray(int[] nums) {
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
