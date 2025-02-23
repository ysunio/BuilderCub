package _150Problems.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortedArrayTest {
    private final MergeSortedArray mergeSortedArray = new MergeSortedArray();

    @Test
    void testMergeSort() {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        int[] expectedArray = new int[]{1, 2, 2, 3, 5, 6};

        mergeSortedArray.merge(nums1, 3, nums2, 3);
        assertArrayEquals(expectedArray, nums1);
    }

    @Test
    void testMergeSort2() {
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{};
        int[] expectedArray = new int[]{1};

        mergeSortedArray.merge(nums1, 1, nums2, 0);
        assertArrayEquals(expectedArray, nums1);
    }


    @Test
    void testMergeSort3() {
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};
        int[] expectedArray = new int[]{1};

        mergeSortedArray.merge(nums1, 0, nums2, 1);
        assertArrayEquals(expectedArray, nums1);
    }

}