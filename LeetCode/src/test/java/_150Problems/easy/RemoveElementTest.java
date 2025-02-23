package _150Problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RemoveElementTest {
    private final RemoveElement removeElement = new RemoveElement();

    @Test
    void removeElementTest(){
        int[] nums = new int[]{3,2,2,3};
        int[] expectedNums = new int[]{2,2};

        int removedIdx = removeElement.removeElement(nums, 3);
        int[] actualNums = Arrays.copyOf(nums, removedIdx);

        assertEquals(2, removedIdx);
        assertArrayEquals(expectedNums, actualNums);
    }

    @Test
    void removeElementTest2(){
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int[] expectedNums = new int[]{0,1,4,0,3};

        int removedIdx = removeElement.removeElement(nums, 2);
        int[] actualNums = Arrays.copyOf(nums, removedIdx);

        assertEquals(5, removedIdx);
        assertArrayEquals(expectedNums, actualNums);
    }

    @Test
    void removeElementTest3(){
        int[] nums = new int[]{1};
        int[] expectedNums = new int[]{};

        int removedIdx = removeElement.removeElement(nums, 1);
        int[] actualNums = Arrays.copyOf(nums, removedIdx);

        assertEquals(0, removedIdx);
        assertArrayEquals(expectedNums, actualNums);
    }

    @Test
    void removeElementTest4(){
        int[] nums = new int[]{};
        int[] expectedNums = new int[]{};

        int removedIdx = removeElement.removeElement(nums, 0);
        int[] actualNums = Arrays.copyOf(nums, removedIdx);

        assertEquals(0, removedIdx);
        assertArrayEquals(expectedNums, actualNums);
    }

    @Test
    void removeElementTest5(){
        int[] nums = new int[]{2};
        int[] expectedNums = new int[]{2};

        int removedIdx = removeElement.removeElement(nums, 3);
        int[] actualNums = Arrays.copyOf(nums, removedIdx);

        assertEquals(1, removedIdx);
        assertArrayEquals(expectedNums, actualNums);
    }

}