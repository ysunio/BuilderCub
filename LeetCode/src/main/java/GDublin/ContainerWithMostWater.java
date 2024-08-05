package GDublin;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxArea = 0;

        int left = 0;
        int right = height.length - 1;

        // Iterating over Two Pointers
        while (left < right) {

            // Find Min of Edge Heights
            int minHeight = Math.min(height[right], height[left]);
            int localArea = minHeight * (right - left);
            maxArea = Math.max(maxArea, localArea);

            // Extra Optimisation (Till left has no > right height, and vice versa )
            while (left < right && height[left] <= minHeight) left++;
            while (left < right && height[right] <= minHeight) right--;
        }

        // Returning Max Area found till now.
        return maxArea;
    }
}
