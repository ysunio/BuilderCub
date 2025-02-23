package _150Problems.easy;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {

        // Base case, handling
        if(nums.length == 0) return 0;

        // Two Pointer Approach
        int idx = 0;
        int idy = nums.length - 1;

        // Iterate over Array, from both sides.
        while(idx < idy){
            if(nums[idx] != val){ idx++; continue; }
            if(nums[idy] == val){ idy--; continue; }

            if(idx >= idy) break;

            // Swap
            int tempSwapValue = nums[idx];
            nums[idx] = nums[idy];
            nums[idy] = tempSwapValue;

            idx++; idy--;
        }

        // Base Case based return (If startIdx is on val, means we have to go back a bit, else idx + 1).
        if(nums[idx] == val) return idx;
        else return idx + 1;
    }

}
