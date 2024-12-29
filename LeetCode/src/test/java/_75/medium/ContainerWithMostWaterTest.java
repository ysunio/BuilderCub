package _75.medium;

import Archieve._75.medium.ContainerWithMostWater;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerWithMostWaterTest {

    @Test
    void maxArea() {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        assertEquals(49, containerWithMostWater.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        assertEquals(1, containerWithMostWater.maxArea(new int[]{1,1}));
    }
}