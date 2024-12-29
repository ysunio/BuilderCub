package Challenges_2023.Sept;

import Archieve.Challenges_2023.Sept.KWeakestRowInMatrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KWeakestRowInMatrixTest {

    @Test
    void shouldReturnShortedPath() {
        KWeakestRowInMatrix kWeakestRowInMatrix = new KWeakestRowInMatrix();
        int[] rankOfRows = kWeakestRowInMatrix.kWeakestRows(new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        }, 3);
        Assertions.assertArrayEquals(new int[]{2, 0, 3}, rankOfRows);
    }

}
