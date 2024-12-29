package Archieve.GDub.Like_100;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SubSetTest {

    @Test
    public void subsetTest(){
        SubSet subSet = new SubSet();
        List<List<Integer>> listOfSubset = subSet.subSet(List.of(1,2,3));
        Assertions.assertArrayEquals(listOfSubset.toArray(), List.of(1).toArray());
    }

}