package org.code.easy;

public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 3, 4, 5, 6, 9, 6, 5, 4, 3, 2}));
    }

    public static int singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) xor ^= num;
        return xor;
    }
}
