package Archieve.GDublin;

import Archieve.GDub.LongestPalindromeString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestPalindromeStringTest {

    @Test
    void longestPalindrome() {
        LongestPalindromeString longestPalindromeString = new LongestPalindromeString();
        Assertions.assertEquals("bab", longestPalindromeString.longestPalindrome("babad"));
        Assertions.assertEquals("a", longestPalindromeString.longestPalindrome("a"));
        Assertions.assertEquals("bb", longestPalindromeString.longestPalindrome("cbbd"));
    }
}