package _75.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeSubStringCountTest {

    @Test
    void countSubstrings() {
        PalindromeSubStringCount palindromeSubStringCount = new PalindromeSubStringCount();
        assertEquals(3, palindromeSubStringCount.countSubstrings("abc") );
        assertEquals(6, palindromeSubStringCount.countSubstrings("aaa") );
    }
}