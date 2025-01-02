package Archieve._75.hard;

import Archieve._75.hard.MinFallingPath_II;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinFallingPath_IITest {

    @Test
    void minFallingPathSum() {
        MinFallingPath_II minFallingPathIi = new MinFallingPath_II();
        int shortestPathSum = minFallingPathIi.minFallingPathSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        assertEquals(13, shortestPathSum);
    }
}