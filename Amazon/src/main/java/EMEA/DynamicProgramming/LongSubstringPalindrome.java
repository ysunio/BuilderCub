package EMEA.DynamicProgramming;

//  Input: s = "babad"
//  Output: "bab"
//  Explanation: "aba" is also a valid answer.
public class LongSubstringPalindrome {

    public static void main(String[] args) {
        System.out.println(subStringPalindrome("babad"));
        System.out.println(subStringPalindrome("cbbd"));
    }

    private static String subStringPalindrome(String str) {
        String evenLengthPalindrome = getMaxPalindromeEven(str);
        String oddLengthPalindrome = getMaxPalindromeOdd(str);
        return evenLengthPalindrome.length() > oddLengthPalindrome.length() ? evenLengthPalindrome : oddLengthPalindrome;
    }

    private static String getMaxPalindromeOdd(String str) {
        String maxString = "";
        for (int idx = 0; idx < str.length(); idx++) {
            int left = idx, right = idx;
            while (left >= 0 && right < str.length()) {
                if (str.charAt(left) == str.charAt(right)) {
                    left--;
                    right++;
                } else break;
            }
            String localPalindrome = str.substring(left + 1, right);
            maxString = localPalindrome.length() > maxString.length() ? localPalindrome : maxString;
        }
        return maxString;
    }

    private static String getMaxPalindromeEven(String str) {
        String maxString = "";
        for (int idx = 0; idx < str.length(); idx++) {
            int left = idx, right = idx + 1;
            while (left >= 0 && right < str.length()) {
                if (str.charAt(left) == str.charAt(right)) {
                    left--;
                    right++;
                } else break;
            }
            String localPalindrome = str.substring(left + 1, right);
            maxString = localPalindrome.length() > maxString.length() ? localPalindrome : maxString;
        }
        return maxString;
    }

}
