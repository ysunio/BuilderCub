package Archieve._75.medium;

import Archieve._75.medium.RearrangeArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RearrangeArrayTest {

    @Test
    void rearrangeArray() {
        RearrangeArray rearrangeArray = new RearrangeArray();
        assertArrayEquals(new int[]{3,-2,1,-5,2,-4}, rearrangeArray.rearrangeArray(new int[]{3,1,-2,-5,2,-4}));
    }
}