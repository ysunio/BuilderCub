package _75.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseVowelsTest {

    @Test
    public void reverseVowelsInString(){
        assertEquals("holle", new ReverseVowels().reverse("hello"));
        assertEquals("leotcede", new ReverseVowels().reverse("leetcode"));
    }

}