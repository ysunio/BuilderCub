package Problems.medium;

public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(-1234));
        System.out.println(reverse(1234));
        System.out.println(reverse(432));
    }

    public static int reverse(int x) {
        int reverse = 0;
        while (x != 0) {
            if (reverse > Integer.MAX_VALUE / 10) return 0;
            if (reverse < Integer.MIN_VALUE / 10) return 0;
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }
        return reverse;
    }
}
