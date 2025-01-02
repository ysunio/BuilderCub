package Archieve._75.easy;

import Archieve._75.easy.MissingNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MissingNumberTest {

    @Test
    void missingNumber() {
        MissingNumber missingNumber = new MissingNumber();
        assertEquals(0, missingNumber.missingNumber(new int[]{1,2,3}));
        assertEquals(1, missingNumber.missingNumber(new int[]{0,2,3}));
        assertEquals(3, missingNumber.missingNumber(new int[]{0,1,2}));
    }
}