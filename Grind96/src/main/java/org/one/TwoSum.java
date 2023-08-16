package org.one;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // O(N) - Time
    // O(N) - Space
    private static int[] __findTwoSumIndex(int[] arr, int target) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int x = 0; x < arr.length; x++) {
            int currentElement = arr[x];
            int requiredElement = target - currentElement;
            if (hash.containsKey(requiredElement)) return new int[]{hash.get(requiredElement), x};
            hash.putIfAbsent(currentElement, x);
        }
        return new int[]{-1, -1};
    }

    // O(N^2) - Time
    // O(1) - Space
    private static int[] _findTwoSumIndex(int[] arr, int target) {
        for (int x = 0; x < arr.length; x++)
            for (int y = 0; y < arr.length; y++)
                if (x != y && arr[x] + arr[y] == target) return new int[]{x, y};
        return new int[]{-1, -1};
    }
}


/*

1. Two Sum

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.


Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.


Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?

*/