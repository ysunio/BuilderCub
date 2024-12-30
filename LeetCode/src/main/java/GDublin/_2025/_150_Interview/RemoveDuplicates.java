package GDublin._2025._150_Interview;

import java.util.Set;
import java.util.TreeSet;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int foundRes = removeDuplicates(nums);
        for(int ix = 0; ix < foundRes; ix++) System.out.println(ix);
    }

    // Most Optimal, and Shortest of All.
    private static int removeDuplicates(int[] nums){
        int uniqueHolderIdx = 0;
        for(int itrIdx = 1; itrIdx < nums.length; itrIdx++){
            if(nums[uniqueHolderIdx] != nums[itrIdx]){
                nums[uniqueHolderIdx + 1] = nums[itrIdx];
                uniqueHolderIdx++;
            }
        }
        return uniqueHolderIdx + 1;
    }

    private int INF = 5000;

    private int removeDuplicates2(int[] nums){
        if(nums.length <= 1) return nums.length;

        // Make all DUPs to 0 first
        int prevEl = nums[0];
        int dupCounts = 0;
        for(int idx = 1; idx < nums.length; idx++){
            int currentEl = nums[idx];
            if(currentEl == prevEl) {
                nums[idx] = INF; dupCounts++;
            }
            prevEl = currentEl;
        }

        // Shift 0's at the End - [1,0,2,0,0,3,4,0,0]
        int leftZero = 0;
        int leftNonZero = leftZero + 1;

        while (leftNonZero < nums.length){
            while(leftZero < nums.length && nums[leftZero] != INF) leftZero++;
            while(leftNonZero < nums.length && nums[leftNonZero] == INF) leftNonZero++;

            if(leftNonZero < leftZero){
                leftNonZero = leftZero + 1;
                continue;
            }

            if(leftZero >= nums.length || leftNonZero >= nums.length) break;

            int swapNode = nums[leftZero];
            nums[leftZero] = nums[leftNonZero];
            nums[leftNonZero] = swapNode;
        }

        return nums.length - dupCounts;
    }

    // OTB Solution considering range of num[values] <-200, and 200>.
     private int removeDuplicates3(int[] nums) {
         int[] uniqueStore = new int[202]; // as range is [-100, 100];
         for(int n: nums){
             uniqueStore[(n + 100)] = -1;
         }

         int len = 0;
         int eIdx = 0;
         for(int idx = 0; idx < 202; idx++){
             if(uniqueStore[idx] != -1) continue;
             int val = idx - 100;
             nums[eIdx++] = val;
             len++;
         }

         return len;
     }

     // Prime Solution - Brute Force
     private int removeDuplicates4(int[] nums) {
         Set<Integer> uniqueStore = new TreeSet<>();
         for(int num: nums) uniqueStore.add(num);

         int idx = 0;
         for(int n: uniqueStore){
             nums[idx] = n;
             idx++;
         }

         return uniqueStore.size();
     }
}
