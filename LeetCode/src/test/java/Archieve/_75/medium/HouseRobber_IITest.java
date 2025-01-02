package Archieve._75.medium;

import Archieve._75.medium.HouseRobber_II;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseRobber_IITest {

    @Test
    void rob() {
        HouseRobber_II houseRobberIi = new HouseRobber_II();
        assertEquals(4, houseRobberIi.rob(new int[]{1,2,3,1}));
        assertEquals(3, houseRobberIi.rob(new int[]{2,3,2}));
    }
}