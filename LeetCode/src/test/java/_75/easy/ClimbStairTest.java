package _75.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClimbStairTest {

    @Test
    void climbStair() {
        ClimbStair climbStair = new ClimbStair();
        assertEquals(89, climbStair.climbStairs(10));
    }
}