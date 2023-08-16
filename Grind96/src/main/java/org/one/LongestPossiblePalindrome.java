package org.one;

public class LongestPossiblePalindrome {
    public int longestPalindrome(String s) {
        int[] freq = new int[256];
        for(char c : s.toCharArray())
            freq[c - 'A']++;

        int evenCount = 0;
        int oddCount = 0;

        for(int i = 0; i < freq.length; i++){
            evenCount += freq[i] / 2;
            if(freq[i] % 2 != 0) oddCount++;
        }

        return (int)(evenCount * 2) + (oddCount > 0 ? 1 : 0);
    }
}
