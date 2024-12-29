package Archieve.Problems.easy;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{4, 3, 2, 5, 7, 9}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{4, 3, 2, 5, 7, 9}, 7)));
    }

//    Time - O(N)
//    Space - O(N)
    private static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> setStore = new HashMap<>();
        for (int idx = 0; idx < nums.length; idx++) {
            int required = target - nums[idx];
            if (setStore.containsKey(required))
                return new int[]{setStore.get(required), idx};
            setStore.put(nums[idx], idx);
        }
        return new int[]{-1, -1};
    }
}
