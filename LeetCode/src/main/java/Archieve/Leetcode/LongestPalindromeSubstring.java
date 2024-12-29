package Archieve.Leetcode;

public class LongestPalindromeSubstring {
    public static void main(String[] args) {
        String str = "babad";
        System.out.println(longestPalindrome(str));

        str = "a";
        System.out.println(longestPalindrome(str));

        str = "abcdcb";
        System.out.println(longestPalindrome(str));
    }

    private static String longestPalindrome(String s) {
        if (s.length() <= 1) return s;

        String maxPalindrome = "";
        for (int idx = 0; idx < s.length() - 1; idx++) {
            int[] oddCase = isPalindrome(s, idx, idx);
            int[] evenCase = isPalindrome(s, idx, idx + 1);

            if ((oddCase[1] - oddCase[0] + 1) > maxPalindrome.length())
                maxPalindrome = s.substring(oddCase[0], oddCase[1] + 1);

            if ((evenCase[1] - evenCase[0] + 1) > maxPalindrome.length())
                maxPalindrome = s.substring(evenCase[0], evenCase[1] + 1);
        }
        return maxPalindrome;
    }

    private static int[] isPalindrome(String s, int sIdx, int yIdx) {
        while (sIdx >= 0 && yIdx < s.length() && s.charAt(sIdx) == s.charAt(yIdx)) {
            if (sIdx == 0 || yIdx == (s.length() - 1)) return new int[]{sIdx, yIdx};
            sIdx--;
            yIdx++;
            if (yIdx == s.length()) return new int[]{sIdx + 1, yIdx - 1};
        }
        if (s.charAt(sIdx) != s.charAt(yIdx)) return new int[]{sIdx + 1, yIdx - 1};
        return new int[]{sIdx, yIdx};
    }
}
