package Archieve._75.medium;

import Archieve._75.medium.MinFallingPath;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinFallingPathTest {

    @Test
    void minFallingPathSum() {
        int[][] pathFalling = new int[][]{{2,1,3},{6,5,4},{7,8,9}};
        int minPathSum = new MinFallingPath().minFallingPathSum(pathFalling);
        assertEquals(13, minPathSum);
    }
}