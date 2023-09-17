package Challenges_2023.Sept;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShortestPathOfAllTest {

    @Test
    void shouldReturnShortedPath(){
        ShortestPathOfAll shortestPathOfAll = new ShortestPathOfAll();
        int shortPath = shortestPathOfAll.shortestPathLength(new int[][]{{1},{0,2,4},{1,3,4},{2},{1,2}});
        Assertions.assertEquals(4, shortPath);
    }
}
