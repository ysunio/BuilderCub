package Archieve._75.easy;

import Archieve._75.easy.IsSubsequence;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsSubsequenceTest {

    @Test
    void isSubsequence() {
        IsSubsequence isSubsequence = new IsSubsequence();
        assertTrue(isSubsequence.isSubsequence("abc", "ahbgdc"));
        assertFalse(isSubsequence.isSubsequence("axc", "ahbgdc"));
        assertFalse(isSubsequence.isSubsequence("sadhkasdl", "ahbgdc"));
    }
}