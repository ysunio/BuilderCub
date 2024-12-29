package _75.easy;

import Archieve._75.easy.MajorityElement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MajorityElementTest {

    @Test
    void majorityElement() {
        MajorityElement majorityElement = new MajorityElement();
        assertEquals(2, majorityElement.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}