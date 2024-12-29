package Archieve.Leetcode;

public class CountSay_Google {
    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {
        String say = "1";
        if (n == 1) return say;
        for (int x = 2; x <= n; x++) say = nextCountSay(say);
        return say;
    }

    public static String nextCountSay(String in) {
        if (in.isEmpty()) return "";

        int count = 1;
        StringBuilder strBuilder = new StringBuilder();

        char prevChar = in.charAt(0);
        int inCount = 1;

        while (inCount < in.length()) {
            if (prevChar == in.charAt(inCount)) {
                count += 1;
            } else {
                strBuilder.append(count);
                strBuilder.append(prevChar);
                count = 1;
            }
            prevChar = in.charAt(inCount);
            inCount++;
        }

        strBuilder.append(count);
        strBuilder.append(prevChar);

        return new String(strBuilder);
    }
}
