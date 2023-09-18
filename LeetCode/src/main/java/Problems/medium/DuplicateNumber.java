package Problems.medium;

public class DuplicateNumber {
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{}));
    }

//    O(N) && O(1)
    public static int findDuplicate(int[] nums) {
        int idx = 0;
        while(idx < nums.length){
            if(nums[Math.abs(nums[idx])] < 0) return Math.abs(nums[idx]);
            nums[Math.abs(nums[idx])] *= -1;
            idx++;
        }
        return -1;
    }

//    O(N) && O(N)
    public int findDuplicate_Space(int[] nums) {
        boolean[] seenNumber = new boolean[nums.length];
        for(int num : nums){
            if(seenNumber[num]) return num;
            seenNumber[num] = true;
        }
        return -1;
    }
}
