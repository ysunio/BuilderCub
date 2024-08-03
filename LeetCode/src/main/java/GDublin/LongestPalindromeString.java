package GDublin;

public class LongestPalindromeString {

//    https://leetcode.com/problems/longest-palindromic-substring/
    public String longestPalindrome(String s) {

        // If given string is empty - No String to Palindrome
        if (s.isEmpty()) return "";

        // Keeping One, as Definite Answer
        String maxString = String.valueOf(s.charAt(0));

        // Looping on Each Node, to extend it -> Left & Right
        for (int x = 0; x < s.length() - 1; x++) {

            // Check for Palindrome starting from idx
            String lSub = lPalindrome(s, x, x);

            // Check for Palindrome starting from idx and idx + 1
            String rSub = lPalindrome(s, x, x + 1);

            // Check, which to take based on answer length
            String aSub = lSub.length() > rSub.length() ? lSub : rSub;

            // Save in Global Var
            maxString = (aSub.length() > maxString.length()) ? aSub : maxString;
        }

        return maxString;
    }

    // Return Palindrome, while extending string
    private String lPalindrome(String s, int idx, int idy) {
        while (idx >= 0 && idy < s.length() && s.charAt(idx) == s.charAt(idy)) {
            idx--;
            idy++;
        }
        return s.substring(idx + 1, idy);
    }
}
