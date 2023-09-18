package Problems.medium;

public class JumpGameII {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
    }

    public static int jump(int[] nums) {
        int minCost = 0;
        int leastElement = nums.length - 1;

        while (leastElement > 0) {
            int idx = leastElement - 1;
            int lastElement = idx - 1;
            while (idx >= 0) {
                if (leastElement - idx <= nums[idx]) lastElement = idx;
                idx--;
            }
            if (leastElement == lastElement) return -1;
            leastElement = lastElement;
            minCost++;
        }
        return minCost;
    }
}
