package Archieve._75.medium;

import Archieve._75.medium.PlayerWithZeroOneLoss;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerWithZeroOneLossTest {

    @Test
    void findWinners() {
        PlayerWithZeroOneLoss playerWithZeroOneLoss = new PlayerWithZeroOneLoss();
        List<List<Integer>> aResult = playerWithZeroOneLoss.findWinners(new int[][]{{2,3},{1,3},{5,4},{6,4}});
        assertEquals(List.of(1,2,5,6), aResult.get(0));
        assertEquals(List.of(), aResult.get(1));
    }
}