package _75.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseRobberTest {

    @Test
    void rob() {
        HouseRobber houseRobber = new HouseRobber();
        assertEquals(4, houseRobber.rob(new int[]{1,2,3,1}));
        assertEquals(12, houseRobber.rob(new int[]{2,7,9,3,1}));
    }
}