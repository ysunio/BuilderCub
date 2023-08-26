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

        public int maxSubArray2(int[] nums) {
            return maxSubArray(nums, 0, nums.length - 1);
        }


        public int maxSubArray(int[] nums, int l, int r) {
            if(l > r) return Integer.MIN_VALUE;

            int mid = l + (r - l) / 2;
            int currentSum = 0, leftSum = 0, rightSum = 0;

            for(int i = mid - 1; i >= l; i--){
                currentSum += nums[i];
                leftSum = Math.max(currentSum, leftSum);
            }

            currentSum = 0;
            for(int i = mid + 1; i <= r; i++){
                currentSum += nums[i];
                rightSum = Math.max(currentSum, rightSum);
            }

            return Math.max(Math.max(maxSubArray(nums, l, mid - 1), maxSubArray(nums, mid + 1, r)),
                    rightSum + leftSum + nums[mid]);
    }
}
