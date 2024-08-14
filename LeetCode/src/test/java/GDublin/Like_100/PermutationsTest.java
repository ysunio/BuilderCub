package GDublin.Like_100;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PermutationsTest {

    @Test
    void permute() {
        Permutations permutations = new Permutations();
        List<List<Integer>> rList =  permutations.permute(new int[]{1,2,3});
        Assertions.assertEquals(6, rList.size());
        Assertions.assertArrayEquals(List.of(1,2,3).toArray(), rList.get(0).toArray());
        Assertions.assertArrayEquals(List.of(3,2,1).toArray(), rList.get(5).toArray());
    }
}