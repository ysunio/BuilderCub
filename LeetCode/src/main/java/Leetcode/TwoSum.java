package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] rIn = new int[]{2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(rIn, target)));
    }

    static private int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> elIndex = new HashMap<>();
        int[] rVal = new int[]{-1, -1};
        for (int xIdx = 0; xIdx < nums.length; xIdx++) {
            int currentElement = nums[xIdx];
            int requiredForTarget = target - currentElement;
            if (elIndex.containsKey(requiredForTarget))
                return new int[]{elIndex.get(requiredForTarget), xIdx};
            else
                elIndex.put(currentElement, xIdx);
        }
        return rVal;
    }
}
