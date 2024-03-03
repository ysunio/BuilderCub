package _75.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquaresSortedArrayTest {

    @Test
    void sortedSquares() {
        SquaresSortedArray squaresSortedArray = new SquaresSortedArray();
        assertArrayEquals(new int[]{1,4,9}, squaresSortedArray.sortedSquares(new int[]{-1,2,3}));
    }
}