package Archieve._75.easy;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int majorityElement = -1;
        int majorityElementCount = 0;

        for (int num : nums) {
            if (majorityElementCount == 0) majorityElement = num;
            if (majorityElement == num) majorityElementCount++;
            else majorityElementCount--;
        }

        return majorityElement;
    }
}
