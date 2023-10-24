package org.ys;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SecondHighestIndexTDDTest {

    @Test
    public void shouldValidateAllScenerios() {
        Assertions.assertEquals(-1, SecondHighestIndexTDD.f(null));
        Assertions.assertEquals(-1, SecondHighestIndexTDD.f(new int[]{}));
        Assertions.assertEquals(-1, SecondHighestIndexTDD.f(new int[]{1, 1}));
        Assertions.assertEquals(2, SecondHighestIndexTDD.f(new int[]{1, 4, 3}));
        Assertions.assertEquals(1, SecondHighestIndexTDD.f(new int[]{4, 3, 1}));
        Assertions.assertEquals(3, SecondHighestIndexTDD.f(new int[]{1, 2, 3, 4, 5}));
        Assertions.assertEquals(1, SecondHighestIndexTDD.f(new int[]{5, 4, 3, 2, 1}));
        Assertions.assertEquals(0, SecondHighestIndexTDD.f(new int[]{1, 2, 1, 2}));
        Assertions.assertEquals(3, SecondHighestIndexTDD.f(new int[]{3, 3, 1, 2}));
        Assertions.assertEquals(1, SecondHighestIndexTDD.f(new int[]{1, 2, 3, 3}));
    }
}