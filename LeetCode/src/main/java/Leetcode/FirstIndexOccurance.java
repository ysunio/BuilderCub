package Leetcode;

public class FirstIndexOccurance {
    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
    }

    public static int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) return -1;

        for (int idx = 0; idx < haystack.length(); idx++) {
            if (strStr(haystack, idx, needle, 0)) return idx;
        }

        return -1;
    }

    private static boolean strStr(String haystack, int hIdx, String needle, int nIdx) {
        if (nIdx == needle.length()) return true;
        if (hIdx >= haystack.length()) return false;

        if (haystack.charAt(hIdx) == needle.charAt(nIdx))
            return strStr(haystack, hIdx + 1, needle, nIdx + 1);
        else return false;
    }
}
