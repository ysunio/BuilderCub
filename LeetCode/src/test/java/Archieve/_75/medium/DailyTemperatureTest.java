package Archieve._75.medium;

import Archieve._75.medium.DailyTemperature;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DailyTemperatureTest {

    @Test
    void dailyTemperatures() {
        int[] r = new DailyTemperature().dailyTemperatures(new int[]{89,62,70,58,47,47,46,76,100,70});
        assertArrayEquals(new int[]{8,1,5,4,3,2,1,1,0,0}, r);
    }
}