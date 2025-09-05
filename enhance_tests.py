#!/usr/bin/env python3

import os
import re
from pathlib import Path

def create_specific_test_cases():
    """Create specific test cases for known problems"""
    
    # Two Sum test
    two_sum_test = """package com.buildercub.arrays;

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
"""

    # Three Sum test
    three_sum_test = """package com.buildercub.arrays;

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
"""

    return {
        'twoSum_1Test.java': two_sum_test,
        'Sum_3Test.java': three_sum_test
    }

def enhance_existing_tests():
    """Enhance existing test files with better implementations"""
    test_cases = create_specific_test_cases()
    
    base_test_dir = "/Users/ysunio/Learning/Coding/BuilderCub/problems/src/test/java/com/buildercub/arrays"
    
    for filename, content in test_cases.items():
        file_path = os.path.join(base_test_dir, filename)
        with open(file_path, 'w') as f:
            f.write(content)
        print(f"Enhanced {filename}")

if __name__ == "__main__":
    enhance_existing_tests()
    print("Test enhancement completed!")
