package _75.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KidsWithGreaterCandiesTest {

    @Test
    void kidsWithCandies() {
        KidsWithGreaterCandies kidsWithGreaterCandies = new KidsWithGreaterCandies();
        assertArrayEquals(new Boolean[]{true,true,true,false,true}, kidsWithGreaterCandies.kidsWithCandies(new int[]{2,3,5,1,3}, 3));
        assertArrayEquals(new Boolean[]{true,false,false,false,false}, kidsWithGreaterCandies.kidsWithCandies(new int[]{4,2,1,1,2}, 1));
        assertArrayEquals(new Boolean[]{true,false,true}, kidsWithGreaterCandies.kidsWithCandies(new int[]{12,1,12}, 10));
    }
}