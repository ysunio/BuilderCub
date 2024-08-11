package GDublin.Like_100;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CombinationSumTest {

    @Test
    void combinationSum() {
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> listOfCombinations = combinationSum.combinationSum(new int[]{2,3,6,7}, 7);
        Assertions.assertEquals(2, listOfCombinations.size());
        Assertions.assertArrayEquals(listOfCombinations.get(0).toArray(), List.of(2,2,3).toArray());
        Assertions.assertArrayEquals(listOfCombinations.get(1).toArray(), List.of(7).toArray());
    }
}