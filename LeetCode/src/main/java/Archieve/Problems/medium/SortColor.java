package Archieve.Problems.medium;

public class SortColor {

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 0, 0, 1, 2, 2};
        sortColors(nums);
        for (int x : nums)
            System.out.print(x + " ");
    }

    public static void sortColors(int[] nums) {
        int left = sort(nums, 0, nums.length - 1, 0);
        sort(nums, left, nums.length - 1, 1);
    }

    private static int sort(int[] nums, int left, int right, int key) {
        while (left < right) {
            while (left < right && nums[left] == key) left++;
            while (left < right && nums[right] != key) right--;
            if (left >= right) break;

            int swap = nums[left];
            nums[left] = nums[right];
            nums[right] = swap;
        }
        return left;
    }
}
