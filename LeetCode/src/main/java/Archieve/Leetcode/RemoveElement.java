package Archieve.Leetcode;

public class RemoveElement {
    public static void main(String[] args) {
        int[] inr = new int[]{2, 1, 2, 3, 4, 5, 6};
        System.out.println(removeElement(inr, 2));
        for (int x : inr) System.out.print(x + " ");
        System.out.println();

        inr = new int[]{3, 1, 2, 3, 4, 5, 6};
        System.out.println(removeElement(inr, 3));
        for (int x : inr) System.out.print(x + " ");
    }

    static int removeElement(int[] nums, int val) {

        int eIdx = nums.length - 1;
        for (int idx = nums.length - 1; idx >= 0; idx--)
            if (nums[idx] == val) eIdx--;
            else break;

        int sIdx = 0;
        for (int idx = 0; idx < nums.length; idx++)
            if (nums[idx] != val) sIdx++;
            else break;

        while (sIdx < eIdx) {
            int swapIdx = nums[sIdx];
            nums[sIdx] = nums[eIdx];
            nums[eIdx] = swapIdx;

            sIdx++;
            eIdx--;
            while (nums[eIdx] == val) eIdx--;
            while (nums[sIdx] != val) sIdx++;
        }

        int l = 0;
        for (int x : nums) if (x != val) l++;

        return l;
    }
}
