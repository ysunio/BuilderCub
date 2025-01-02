package Archieve._75.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeAlternativelyTest {

    @Test
    void mergeAlternatelyWithBothString() {
        MergeAlternatively mergeAlternatively = new MergeAlternatively();
        String actualWithCharArray = mergeAlternatively.mergeAlternatelyWithCharArray("abc", "def");
        String actualWithBuilder = mergeAlternatively.mergeAlternatelyWithBuilder("abc", "def");

        String expectedString = "adbecf";

        assertEquals(expectedString, actualWithCharArray);
        assertEquals(expectedString, actualWithBuilder);
    }

    @Test
    void mergeAlternatelyWithSingleString() {
        MergeAlternatively mergeAlternatively = new MergeAlternatively();
        String actualWithCharArray = mergeAlternatively.mergeAlternatelyWithCharArray("abc", "");
        String actualWithBuilder = mergeAlternatively.mergeAlternatelyWithBuilder("", "abc");

        String expectedString = "abc";

        assertEquals(expectedString, actualWithCharArray);
        assertEquals(expectedString, actualWithBuilder);
    }
}