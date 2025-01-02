package Archieve._75.easy;

import Archieve._75.easy.FindTown;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindTownTest {

    @Test
    void findJudge() {
        FindTown findTown = new FindTown();
        assertEquals(3, findTown.findJudge(3, new int[][]{{1,3},{2,3}}));
    }
}