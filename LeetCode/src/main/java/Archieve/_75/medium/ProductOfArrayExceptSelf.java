package Archieve._75.medium;

public class ProductOfArrayExceptSelf {
        public int[] productExceptSelf(int[] nums) {
            int[] lMul = new int[nums.length];
            int[] rMul = new int[nums.length];

            // Base Case
            lMul[0] = 1;
            rMul[rMul.length - 1] = 1;

            // Left
            for(int idx = 1; idx < nums.length; idx++){
                lMul[idx] = lMul[idx - 1] * nums[idx - 1];
            }

            // Right
            for(int idx = nums.length - 2; idx >= 0; idx--){
                rMul[idx] = rMul[idx + 1] * nums[idx + 1];
            }

            // Mul = Left * Right
            for(int idx = 1; idx < nums.length - 1; idx++){
                nums[idx] = lMul[idx] * rMul[idx];
            }

            // Edges
            nums[0] = rMul[0];
            nums[nums.length - 1] = lMul[nums.length - 1];

            return nums;
    }
}
