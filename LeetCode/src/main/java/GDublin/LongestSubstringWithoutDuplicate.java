package GDublin;

import java.util.Arrays;

public class LongestSubstringWithoutDuplicate {

    // https://leetcode.com/problems/longest-substring-without-repeating-characters
    public int lengthOfLongestSubstring(String s) {

        // Char Store, to hold String Index
        int[] indexCharMap = new int[256];
        Arrays.fill(indexCharMap, -1);

        char[] sChar = s.toCharArray();
        int globalMax = 0;
        int left = 0, right = 0;

        // Iterate over String, as Window Strategy
        while (right < sChar.length) {

            // If current char is in between left and right window
            if (indexCharMap[sChar[right]] >= left) {
                left = indexCharMap[sChar[right]] + 1;
            }

            // Storing index into char_store
            indexCharMap[sChar[right]] = right;

            // Calculating, max len based on left & right.
            globalMax = Math.max(globalMax, right - left + 1);
            right++;
        }

        return globalMax;
    }
}
