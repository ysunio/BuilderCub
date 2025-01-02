package Archieve._75.hard;

import Archieve._75.hard.CherryPickII;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CherryPickIITest {

    @Test
    void cherryPickup() {
        CherryPickII cherryPickII = new CherryPickII();
        assertEquals(28, cherryPickII.cherryPickup(new int[][]{{1, 0, 0, 0, 0, 0, 1}, {2, 0, 0, 0, 0, 3, 0}, {2, 0, 9, 0, 0, 0, 0}, {0, 3, 0, 5, 4, 0, 0}, {1, 0, 2, 3, 0, 0, 6}}));
    }
}