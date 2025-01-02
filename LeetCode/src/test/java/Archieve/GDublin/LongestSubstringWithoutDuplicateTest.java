package Archieve.GDublin;

import Archieve.GDub.LongestSubstringWithoutDuplicate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringWithoutDuplicateTest {

    @Test
    void lengthOfLongestSubstring() {
        LongestSubstringWithoutDuplicate longestSubstringWithoutDuplicate = new LongestSubstringWithoutDuplicate();
        Assertions.assertEquals(longestSubstringWithoutDuplicate.lengthOfLongestSubstring("abcabcbb"), 3);
        Assertions.assertEquals(longestSubstringWithoutDuplicate.lengthOfLongestSubstring("bbbbb"), 1);
        Assertions.assertEquals(longestSubstringWithoutDuplicate.lengthOfLongestSubstring("pwwkew"), 3);
    }
}