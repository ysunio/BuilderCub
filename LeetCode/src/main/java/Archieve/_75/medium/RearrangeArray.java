package Archieve._75.medium;

public class RearrangeArray {
    public int[] rearrangeArray(int[] nums) {
        int[] result = new int[nums.length];

        int positiveIdx = 0;
        int negativeIdx = 1;

        for (int num : nums) {
            if (num > 0) {
                result[positiveIdx] = num;
                positiveIdx += 2;
            } else {
                result[negativeIdx] = num;
                negativeIdx += 2;
            }
        }

        return result;
    }
}
