package Leetcode;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));

        str = "pwwkew";
        System.out.println(lengthOfLongestSubstring(str));

        str = "bbbbb";
        System.out.println(lengthOfLongestSubstring(str));
    }
    private static int lengthOfLongestSubstring(String s) {
        int lengthOfLongestSubstring = 0;
        int[] freqChar = new int[256];
        int leftCounter = 0;

        for (int rightCounter = 0; rightCounter < s.length(); rightCounter++) {
            char currentChar = s.charAt(rightCounter);
            freqChar[currentChar]++;
            while (freqChar[currentChar] > 1) freqChar[s.charAt(leftCounter++)]--;
            lengthOfLongestSubstring = Math.max(lengthOfLongestSubstring, rightCounter - leftCounter + 1);
        }

        return lengthOfLongestSubstring;
    }
}
