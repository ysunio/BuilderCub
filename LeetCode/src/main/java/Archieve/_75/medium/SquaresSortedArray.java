package Archieve._75.medium;

public class SquaresSortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] r = new int[nums.length];

        int lIdx = 0;
        int rIdx = nums.length - 1;

        int rrIdx = nums.length - 1;

        while (lIdx <= rIdx) {
            int lEl = Math.abs(nums[lIdx]);
            int rEl = Math.abs(nums[rIdx]);

            if (lEl > rEl) {
                r[rrIdx--] = lEl * lEl;
                lIdx++;
            } else {
                r[rrIdx--] = rEl * rEl;
                rIdx--;
            }
        }

        return r;
    }


}
