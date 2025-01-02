package Archieve._75.medium;

import Archieve._75.medium.LongestSubSequence;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubSequenceTest {

    @Test
    void longestCommonSubsequence() {
        LongestSubSequence longestSubSequence = new LongestSubSequence();
        assertEquals(5,longestSubSequence.longestCommonSubsequence("SUNIL", "YADSUNILAV"));
    }
}