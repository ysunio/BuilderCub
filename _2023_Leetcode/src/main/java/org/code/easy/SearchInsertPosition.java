package org.code.easy;

public class SearchInsertPosition {
    public static void main(String[] args) {
        System.out.println((searchInsert(new int[]{3, 4, 5, 8, 9}, 7)));
    }

    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        if (target < nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (target <= nums[mid])
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }
}
