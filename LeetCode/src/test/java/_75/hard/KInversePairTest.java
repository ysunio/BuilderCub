package _75.hard;

import Archieve._75.hard.KInversePair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KInversePairTest {

    @Test
    void kInversePairs() {
        KInversePair kInversePair = new KInversePair();
        assertEquals(1068, kInversePair.kInversePairs(10, 5));
        assertEquals(169, kInversePair.kInversePairs(7, 5));
    }
}