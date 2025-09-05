package com.buildercub.backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/permutations
public class Permutations {

    private List<List<Integer>> rList = new ArrayList<>();

    // Main function
    public List<List<Integer>> permute(int[] nums) {
        rList = new ArrayList<>();
        solve(nums, new ArrayList<>());
        return rList;
    }

    // Recursive function, to go over list in tree fashion
    private void solve(int[] nums, List<Integer> tList) {

        // Base, when temp list has all the element
        if (tList.size() == nums.length) {
            rList.add(new ArrayList<>(tList));
            return;
        }

        // For each number, try inserting it
        for (int num : nums) {
            // Ignore the path if, element is already in tempList.
            if (tList.contains(num)) continue;
            tList.add(num);
            solve(nums, tList);
            tList.remove(tList.size() - 1);
        }
    }
}
