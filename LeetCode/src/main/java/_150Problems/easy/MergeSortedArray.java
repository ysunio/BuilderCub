package _150Problems.easy;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        if (m + n < nums1.length) return;

        shiftNumsOnesAtEnd(nums1, m);
        mergeTheArrays(nums1, nums1, nums1.length - m, nums2, 0);
    }

    private void mergeTheArrays(int[] result, int[] numsA, int idxA, int[] numsB, int idxB) {
        int rIdx = 0;

        while (idxA < numsA.length || idxB < numsB.length) {

            if (idxA >= numsA.length) {
                result[rIdx++] = numsB[idxB++];
                continue;
            }

            if (idxB >= numsB.length) {
                result[rIdx++] = numsA[idxA++];
                continue;
            }

            if (numsA[idxA] < numsB[idxB]) result[rIdx++] = numsA[idxA++];
            else result[rIdx++] = numsB[idxB++];

        }
    }

    // 1,2,3,0,0,0,0,0 : Shift the Elements at the End
    // End Index of Num : m - 1
    // End of Array : nums.length - 1;
    private void shiftNumsOnesAtEnd(int[] nums, int m) {
        int eIdx = nums.length - 1;
        int eN = m - 1;
        while (eN >= 0) nums[eIdx--] = nums[eN--];
    }

}
