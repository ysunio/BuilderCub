package EMEA.Array;

public class ContainerWithMostWater {

    //    Height = [1,8,6,2,5,4,8,3,7]
//    Output: 49
    public static void main(String[] args) {
        System.out.println(maxWater(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    private static int maxWater(int[] height) {
        int maxSum = Integer.MIN_VALUE;

        int startIdx = 0;
        int endIdx = height.length - 1;

        while (startIdx < endIdx) {
            int currentWaterContentFlatStore = Math.min(height[startIdx], height[endIdx]) * (endIdx - startIdx);
            maxSum = Math.max(maxSum, currentWaterContentFlatStore);
            if (height[startIdx] < height[endIdx])
                startIdx++;
            else endIdx--;
        }

        return maxSum;
    }


}
