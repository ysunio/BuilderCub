package Archieve.Problems.easy;

public class MajorityElement {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{4, 3, 2, 3, 4, 3, 2, 2, 2, 2, 3, 4, 5, 4, 3, 2, 2, 2, 2, 2, 2,}));
    }

    public static int majorityElement(int[] nums) {
        int m = 0;
        int value = 0;
        for (int num : nums) {
            if (m == 0) {
                m++;
                value = num;
            } else {
                if (num == value) m++;
                else m--;
            }

            if (m == 0) value = num;
        }
        return value;
    }
}
