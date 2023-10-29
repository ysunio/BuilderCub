package EMEA.Array;

public class FirstLastInSortedArray {

    public static void main(String[] args) {
        int[] range = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(range[0] + " :: " + range[1]);
    }

    private static int[] searchRange(int[] nums, int target) {
        int[] range = new int[]{-1, -1};
        for (int idx = 0; idx < nums.length; idx++) {
            if (nums[idx] == target) {
                if (range[0] == -1) range[0] = idx;
                range[1] = idx;
            }
        }
        return range;
    }
}
