package _150Problems.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CanJumpTest {

    private final CanJump canJump = new CanJump();

    @Test
    void canJump() {
        int[] in = new int[]{2, 3, 1, 1, 4};
        assertTrue(canJump.canJump(in));
        assertTrue(canJump.canJump2(in));
    }

    @Test
    void canJump2() {
        int[] in = new int[]{3, 2, 1, 0, 4};
        assertFalse(canJump.canJump(in));
        assertFalse(canJump.canJump2(in));
    }

    @Test
    void canJump3() {
        int[] in = new int[]{2, 0};
        assertTrue(canJump.canJump2(in));
        assertTrue(canJump.canJump(in));
    }

}