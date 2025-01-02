package Archieve._75.medium;

import Archieve._75.medium.MaxLenSubsequenceUniqueChar;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaxLenSubsequenceUniqueCharTest {

    @Test
    void maxLength() {
        MaxLenSubsequenceUniqueChar max = new MaxLenSubsequenceUniqueChar();
        assertEquals(4, max.maxLength(List.of("un","iq","ue")));
        assertEquals(6, max.maxLength(List.of("cha","r","act","ers")));
    }
}