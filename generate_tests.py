#!/usr/bin/env python3

import os
import re
import subprocess
from pathlib import Path

def extract_class_info(file_path):
    """Extract class name and method signatures from Java file"""
    with open(file_path, 'r') as f:
        content = f.read()
    
    # Extract class name
    class_match = re.search(r'public class (\w+)', content)
    class_name = class_match.group(1) if class_match else None
    
    # Extract public methods (excluding main)
    method_pattern = r'public static (\w+(?:<[^>]+>)?(?:\[\])*) (\w+)\(([^)]*)\)'
    methods = re.findall(method_pattern, content)
    
    # Filter out main method
    methods = [(return_type, method_name, params) for return_type, method_name, params in methods if method_name != 'main']
    
    return class_name, methods, content

def infer_problem_info(class_name, content):
    """Infer problem statement and complexity from class name and code"""
    problem_info = {
        'twoSum_1': {
            'statement': 'Given an array of integers and a target sum, return indices of two numbers that add up to target.',
            'approach': 'Brute force - check all pairs',
            'time': 'O(n²)',
            'space': 'O(1)'
        },
        'Sum_3': {
            'statement': 'Given an array, find all unique triplets that sum to zero.',
            'approach': 'Sort array, use two pointers for each element',
            'time': 'O(n²)',
            'space': 'O(1)'
        },
        'mergeSortedList_21': {
            'statement': 'Merge two sorted linked lists into one sorted list.',
            'approach': 'Two pointers traversal',
            'time': 'O(m+n)',
            'space': 'O(1)'
        }
    }
    
    # Default inference based on class name patterns
    if class_name in problem_info:
        return problem_info[class_name]
    
    # Pattern-based inference
    if 'sort' in class_name.lower():
        return {
            'statement': f'Sorting related problem: {class_name}',
            'approach': 'Sorting algorithm implementation',
            'time': 'O(n log n)',
            'space': 'O(1) or O(n)'
        }
    elif 'search' in class_name.lower():
        return {
            'statement': f'Search related problem: {class_name}',
            'approach': 'Search algorithm implementation',
            'time': 'O(log n) or O(n)',
            'space': 'O(1)'
        }
    elif 'tree' in class_name.lower() or 'BT' in class_name:
        return {
            'statement': f'Binary tree related problem: {class_name}',
            'approach': 'Tree traversal or manipulation',
            'time': 'O(n)',
            'space': 'O(h) where h is height'
        }
    else:
        return {
            'statement': f'Problem: {class_name.replace("_", " ")}',
            'approach': 'Algorithm implementation',
            'time': 'O(n)',
            'space': 'O(1)'
        }

def generate_test_class(class_name, methods, problem_info, package_name):
    """Generate JUnit test class"""
    
    test_content = f"""package com.buildercub.{package_name};

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {class_name}
 * 
 * Problem Statement: {problem_info['statement']}
 * Approach: {problem_info['approach']}
 * Time Complexity: {problem_info['time']}
 * Space Complexity: {problem_info['space']}
 */
class {class_name}Test {{

"""

    # Generate test methods for each public method
    for return_type, method_name, params in methods:
        test_content += f"""    @Test
    @DisplayName("Test {method_name} - basic functionality")
    void test{method_name.capitalize()}() {{
        // TODO: Add test cases for {method_name}
        // Test with valid inputs
        // Test with edge cases
        // Test with invalid inputs if applicable
        
        // Example test structure:
        // Given
        // When
        // Then
        assertTrue(true, "Placeholder test - implement actual test cases");
    }}

"""

    # Add edge case tests
    test_content += f"""    @Test
    @DisplayName("Test edge cases")
    void testEdgeCases() {{
        // TODO: Add edge case tests
        // Empty inputs, null inputs, boundary values, etc.
        assertTrue(true, "Placeholder test - implement edge case tests");
    }}

    @Test
    @DisplayName("Test performance characteristics")
    void testPerformance() {{
        // TODO: Add performance tests if needed
        // Large inputs, time complexity verification
        assertTrue(true, "Placeholder test - implement performance tests");
    }}
}}
"""
    
    return test_content

def process_directory(src_dir, test_dir, package_name):
    """Process all Java files in a directory"""
    src_path = Path(src_dir)
    test_path = Path(test_dir)
    
    if not src_path.exists():
        return
    
    test_path.mkdir(parents=True, exist_ok=True)
    
    for java_file in src_path.glob("*.java"):
        if java_file.name == "Helper.java":  # Skip utility classes
            continue
            
        print(f"Processing {java_file.name}...")
        
        class_name, methods, content = extract_class_info(java_file)
        if not class_name:
            continue
            
        problem_info = infer_problem_info(class_name, content)
        test_content = generate_test_class(class_name, methods, problem_info, package_name)
        
        test_file_path = test_path / f"{class_name}Test.java"
        with open(test_file_path, 'w') as f:
            f.write(test_content)

def main():
    base_src = "/Users/ysunio/Learning/Coding/BuilderCub/problems/src/main/java/com/buildercub"
    base_test = "/Users/ysunio/Learning/Coding/BuilderCub/problems/src/test/java/com/buildercub"
    
    categories = [
        "arrays", "strings", "trees", "linkedlists", "math", "graphs", 
        "searching", "sorting", "backtracking", "dynamicprogramming", "greedy", "misc"
    ]
    
    for category in categories:
        src_dir = f"{base_src}/{category}"
        test_dir = f"{base_test}/{category}"
        print(f"\nProcessing {category} category...")
        process_directory(src_dir, test_dir, category)
    
    print("\nTest generation completed!")

if __name__ == "__main__":
    main()
