package Archieve.Problems.medium;

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        for (int x : productExceptSelf(new int[]{1, 2, 3, 4})) {
            System.out.print(x + " >> ");
        }
    }


    // O(N) && O(2N)
    public static int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for (int idx = 1; idx < nums.length; idx++) {
            left[idx] = left[idx - 1] * nums[idx - 1];
        }

        for (int idx = nums.length - 2; idx >= 0; idx--) {
            right[idx] = right[idx + 1] * nums[idx + 1];
            left[idx] *= right[idx];
        }

        return left;
    }

//    O(N) && O(N)
    public int[] productExceptSelf_Two(int[] nums) {
        int[] left = new int[nums.length];
        Arrays.fill(left, 1);

        for (int idx = 1; idx < nums.length; idx++) {
            left[idx] = left[idx - 1] * nums[idx - 1];
        }

        int prop = 1;
        for (int idx = nums.length - 2; idx >= 0; idx--) {
            prop = prop * nums[idx + 1];
            left[idx] *= prop;
        }

        return left;
    }
}
