package GDublin._2025._150_Interview;

public class ProductExceptSelf {

    public static void main(String[] args) {
        int[] r = productExceptSelf(new int[]{1, 2, 3, 4});
        int[] r2 = productExceptSelf(new int[]{-1, 1, 0, -3, 3});
        for (int c : r) System.out.printf(c + " ");
        System.out.println();
        for (int c : r2) System.out.printf(c + " ");
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = 1;
        right[nums.length - 1] = 1;

        for(int idx = 1; idx < nums.length; idx++){
            left[idx] = left[idx - 1] * nums[idx - 1];
        }

        for(int idx = nums.length - 2; idx >= 0; idx--){
            right[idx] = right[idx + 1] * nums[idx + 1];
        }

        int[] res = new int[nums.length];
        for(int idx = 0; idx < nums.length; idx++){
            res[idx] = right[idx] * left[idx];
        }

        return res;
    }
}
