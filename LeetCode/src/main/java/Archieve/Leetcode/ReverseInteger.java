package Archieve.Leetcode;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(-767867123));
    }
        private static int reverse(int x) {
            long rX = 0;

            while(x != 0){
                rX *= 10;
                rX += x % 10;
                x /= 10;
            }

            return rX >= Integer.MAX_VALUE || rX <= Integer.MIN_VALUE ? 0 : (int) rX;
        }
}
