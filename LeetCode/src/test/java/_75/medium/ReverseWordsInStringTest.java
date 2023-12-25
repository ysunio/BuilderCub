package _75.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseWordsInStringTest {

    @Test
    void reverseWords() {
        ReverseWordsInString r = new ReverseWordsInString();
        assertEquals("blue is sky the", r.reverseWords("the sky is blue"));
        assertEquals("world hello", r.reverseWords("  hello world  "));
        assertEquals("example good a", r.reverseWords("a good   example"));
    }
}