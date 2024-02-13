package _75.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstPalindromeTest {

    @Test
    void firstPalindrome() {
        FirstPalindrome firstPalindrome = new FirstPalindrome();
        String fP = firstPalindrome.firstPalindrome(new String[]{"dsfsa", "adsd", "ababa", "wuyh"});
        assertEquals("ababa", fP);
    }
}