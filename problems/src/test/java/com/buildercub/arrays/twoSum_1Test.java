package com.buildercub.arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for twoSum_1
 * 
 * Problem Statement: Given an array of integers and a target sum, return indices of two numbers that add up to target.
 * Approach: Brute force - check all pairs
 * Time Complexity: O(n²)
 * Space Complexity: O(1)
 */
class twoSum_1Test {

    @Test
    @DisplayName("Test twoSum with valid input")
    void testTwoSumValidInput() {
        // Given
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        
        // When
        int[] result = twoSum_1.twoSum(nums, target);
        
        // Then
        assertNotNull(result);
        assertEquals(2, result.length);
        assertEquals(9, nums[result[0]] + nums[result[1]]);
    }

    @Test
    @DisplayName("Test twoSum with no solution")
    void testTwoSumNoSolution() {
        // Given
        int[] nums = {1, 2, 3, 4};
        int target = 10;
        
        // When
        int[] result = twoSum_1.twoSum(nums, target);
        
        // Then
        assertNotNull(result);
        assertEquals(0, result[0]);
        assertEquals(0, result[1]);
    }

    @Test
    @DisplayName("Test twoSum with negative numbers")
    void testTwoSumNegativeNumbers() {
        // Given
        int[] nums = {-3, 4, 3, 90};
        int target = 0;
        
        // When
        int[] result = twoSum_1.twoSum(nums, target);
        
        // Then
        assertNotNull(result);
    }

    @Test
    @DisplayName("Test edge cases")
    void testEdgeCases() {
        // Test with minimum array size
        int[] nums = {3, 3};
        int target = 6;
        int[] result = twoSum_1.twoSum(nums, target);
        assertNotNull(result);
    }
}
