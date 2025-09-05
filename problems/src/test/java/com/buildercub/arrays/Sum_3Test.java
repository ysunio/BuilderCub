package com.buildercub.arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

/**
 * Unit tests for Sum_3
 * 
 * Problem Statement: Given an array, find all unique triplets that sum to zero.
 * Approach: Sort array, use two pointers for each element
 * Time Complexity: O(n²)
 * Space Complexity: O(1)
 */
class Sum_3Test {

    @Test
    @DisplayName("Test threeSum with valid triplets")
    void testThreeSumValidTriplets() {
        // Given
        int[] nums = {-1, 0, 1, 2, -1, -4};
        
        // When
        List<List<Integer>> result = Sum_3.threeSum(nums);
        
        // Then
        assertNotNull(result);
        assertFalse(result.isEmpty());
        
        // Verify each triplet sums to zero
        for (List<Integer> triplet : result) {
            assertEquals(3, triplet.size());
            assertEquals(0, triplet.get(0) + triplet.get(1) + triplet.get(2));
        }
    }

    @Test
    @DisplayName("Test threeSum with no triplets")
    void testThreeSumNoTriplets() {
        // Given
        int[] nums = {0, 1, 1};
        
        // When
        List<List<Integer>> result = Sum_3.threeSum(nums);
        
        // Then
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Test threeSum with all zeros")
    void testThreeSumAllZeros() {
        // Given
        int[] nums = {0, 0, 0};
        
        // When
        List<List<Integer>> result = Sum_3.threeSum(nums);
        
        // Then
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(0, result.get(0).get(0) + result.get(0).get(1) + result.get(0).get(2));
    }
}
