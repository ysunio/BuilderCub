package org.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class KadaneAlgoTest {

    @Test
    void shouldReturnMaxValue(){
        KadaneAlgo kadaneAlgo = new KadaneAlgo();
        int maxValue = kadaneAlgo.maxSubArray(new int[]{3,2,-3,4,-5,-6,3});
        Assertions.assertEquals(6, maxValue);
    }

    @Test
    void shouldReturnMaxValueNegative(){
        KadaneAlgo kadaneAlgo = new KadaneAlgo();
        int maxValue = kadaneAlgo.maxSubArray(new int[]{-1});
        Assertions.assertEquals(-1, maxValue);
    }

    @Test
    void shouldReturnMaxValueNegativeWithDQ(){
        KadaneAlgo kadaneAlgo = new KadaneAlgo();
        int maxValue = kadaneAlgo.maxSubArray2(new int[]{-1});
        Assertions.assertEquals(-1, maxValue);
    }

}