package Problems.easy;

public class RemoveElement {

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 3));
    }

    public static int removeElement(int[] nums, int val) {
        int elCount = 0;
        for (int el : nums) elCount = el == val ? elCount + 1 : elCount;

        int cIdx = 0;
        int rIdx = 0;

        while (rIdx < nums.length && cIdx < nums.length) {
            while (rIdx < nums.length && nums[rIdx] == val) {
                rIdx++;
                continue;
            }
            if (rIdx == nums.length) break;

            nums[cIdx] = nums[rIdx];
            cIdx++;
            rIdx++;
        }

        return nums.length - elCount;
    }
}
