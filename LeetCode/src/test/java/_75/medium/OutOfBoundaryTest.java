package _75.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutOfBoundaryTest {

    @Test
    void findPaths() {
        OutOfBoundary outOfBoundary = new OutOfBoundary();
        assertEquals(914783380, outOfBoundary.findPaths(8, 50, 23, 5, 26));
    }
}