package Problems.hard;

public class FirstMissingPositive {

    int firstMissingPositive(int[] nums) {

        boolean hasOne = false;
        for (int x : nums) if (x == 1) hasOne = true;
        if (!hasOne) return 1;

        for (int idx = 0; idx < nums.length; idx++) {
            if (nums[idx] <= 0 || nums[idx] > nums.length) nums[idx] = 1;
        }

        for (int idx = 0; idx < nums.length; idx++) {
            int cElement = Math.abs(nums[idx]) - 1;
            if ((nums[cElement]) > 0) {
                nums[cElement] *= -1;
            }
        }

        for (int idx = 0; idx < nums.length; idx++) {
            if (nums[idx] > 0) return idx + 1;
        }

        return nums.length + 1;
    }

}
