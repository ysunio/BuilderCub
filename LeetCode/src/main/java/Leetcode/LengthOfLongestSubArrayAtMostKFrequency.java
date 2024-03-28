package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubArrayAtMostKFrequency {

    public static void main(String[] args) {
        int[] rIn = new int[]{1,2,1,2,1,2,1,2}; int rK = 1;
        System.out.println(maxSubArrayLength(rIn, rK));

        rIn = new int[]{1,2,3,1,2,3,1,2}; rK = 2;
        System.out.println(maxSubArrayLength(rIn, rK));
    }

    static int maxSubArrayLength(int[] nums, int k) {
        Map<Integer, Integer> freqElement = new HashMap<>();
        int leftCounter = 0;
        int maxSubArray = 0;

        for(int rightCounter = 0; rightCounter < nums.length; rightCounter++){
            freqElement.put(nums[rightCounter], freqElement.getOrDefault(nums[rightCounter], 0) + 1);
            while(freqElement.get(nums[rightCounter]) > k){
                freqElement.put(nums[leftCounter], freqElement.getOrDefault(nums[leftCounter], 0) - 1);
                leftCounter++;
            }
            maxSubArray = Math.max(maxSubArray, rightCounter - leftCounter + 1);
        }
        return maxSubArray;
    }
}
