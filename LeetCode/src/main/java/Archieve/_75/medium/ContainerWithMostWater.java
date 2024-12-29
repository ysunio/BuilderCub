package Archieve._75.medium;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = -1;

        int sIdx = 0;
        int eIdx = height.length - 1;

        while(sIdx <= eIdx){
            int cAreal = (eIdx - sIdx) * Math.min(height[sIdx], height[eIdx]);
            maxArea = Math.max(maxArea, cAreal);
            if(height[sIdx] > height[eIdx]) eIdx--; else sIdx++;
        }

        return maxArea;
    }
}
