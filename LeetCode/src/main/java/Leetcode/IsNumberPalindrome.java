package Leetcode;

public class IsNumberPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(1221));
    }

    static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int rev = 0;
        int cX = x;

        while (cX != 0) {
            rev *= 10;
            rev += cX % 10;
            cX /= 10;
        }

        return rev == x;
    }
}
