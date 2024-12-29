package Archieve.GDub.Like_100;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/palindrome-partitioning/description
public class PalindromePartition {
    private List<List<String>> fResult = new ArrayList<>();

    // Finding list of Partitioned Palindrome String
    public List<List<String>> partition(String s) {
        fResult = new ArrayList<>();
        solve(s, 0, new ArrayList<>());
        return fResult;
    }

    // Recursive Method, to find each palindrome and validate it.
    private void solve(String s, int idx, List<String> lStr) {
        if (idx >= s.length()) {
            fResult.add(new ArrayList<>(lStr));
            return;
        }

        // Chunking forward element i.e. Substring to build and validate palindrome
        for (int l = idx + 1; l <= s.length(); l++) {
            String sStr = s.substring(idx, l);
            // If Element is Palindrome, move forward in the list.
            if (isStrPalindrome(sStr)) {
                lStr.add(sStr);
                solve(s, l, lStr);
                lStr.remove(lStr.size() - 1);
            }
        }
    }

    // Common Routine, to check if string is palindrome
    private boolean isStrPalindrome(String sStr) {
        int sIdx = 0;
        int lIdx = sStr.length() - 1;
        while (sIdx < lIdx) {
            if (sStr.charAt(sIdx) != (sStr.charAt(lIdx))) return false;
            sIdx++;
            lIdx--;
        }
        return true;
    }
}
