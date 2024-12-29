package _75.easy;

import Archieve._75.easy.SetMisMatch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SetMisMatchTest {

    @Test
    void findErrorNums() {
        SetMisMatch setMisMatch = new SetMisMatch();
        assertArrayEquals(new int[]{2, 1}, setMisMatch.findErrorNums(new int[]{2, 2, 3}));
        assertArrayEquals(new int[]{1, 2}, setMisMatch.findErrorNums(new int[]{1, 1, 3}));
    }
}