package _75.easy;

import Archieve._75.easy.UniqueOccurrence;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniqueOccurrenceTest {

    @Test
    void uniqueOccurrences() {
        UniqueOccurrence uniqueOccurrence = new UniqueOccurrence();
        assertFalse(uniqueOccurrence.uniqueOccurrences(new int[]{1000,2,2,-1000,1,3}));
        assertTrue(uniqueOccurrence.uniqueOccurrences(new int[]{1,2,2,1,1,3}));
        assertTrue(uniqueOccurrence.uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));
    }
}