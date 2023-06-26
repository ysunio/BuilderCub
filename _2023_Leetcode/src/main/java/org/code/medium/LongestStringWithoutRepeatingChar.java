package org.code.medium;

public class LongestStringWithoutRepeatingChar {
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
        System.out.println(lengthOfLongestSubstring_Optimal(str));
    }

    // O(N)
    public static int lengthOfLongestSubstring_Optimal(String s) {
        boolean[] visitedChar = new boolean[256];
        int left = 0;
        int maxLen = 0;
        for(int right = 0; right < s.length(); right++){
            char currentChar = s.charAt(right);
            while(visitedChar[currentChar]){
                visitedChar[s.charAt(left)] = false;
                left++;
            }
            visitedChar[currentChar] = true;
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    // O(N^2)
    public static int lengthOfLongestSubstring(String s) {
        int strLen = s.length();
        if(strLen <= 1) return strLen;

        int longestSubString = 0;
        for(int idx = 0; idx < strLen; idx++){
            int[] store = new int[256];
            int left = idx;
            int right = idx;
            char currentChar = s.charAt(idx);
            store[currentChar] = 1;

            left--;
            right++;

            while(left >= 0 && right < strLen){
                int leftChar = s.charAt(left);
                int rightChar = s.charAt(right);
                if(store[leftChar] == 1) break;
                store[leftChar] = 1;
                if(store[rightChar] == 1) break;
                store[rightChar] = 1;
                left--; right++;
            }

            while(left >= 0){
                int leftChar = s.charAt(left);
                if(store[leftChar] == 1) break;
                store[leftChar] = 1;
                left--;
            }

            while(right < strLen){
                int rightChar = s.charAt(right);
                if(store[rightChar] == 1) break;
                store[rightChar] = 1;
                right++;
            }

            int tempLen = 0;
            for(int charValue : store)
                if(charValue == 1) tempLen++;

            longestSubString = Math.max(longestSubString, tempLen);
        }
        return longestSubString;
    }
}
