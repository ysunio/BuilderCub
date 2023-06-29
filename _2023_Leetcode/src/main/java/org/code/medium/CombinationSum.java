package org.code.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,6,7}, 7));
    }
    static List<List<Integer>> res;
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        traverse(candidates, target, 0, new ArrayList<>());
        return new ArrayList<>(res);
    }

    private static void traverse(int[] candidates, int target, int idx, List<Integer> tarSequence){
        if(target < 0 || idx >= candidates.length) return;
        if(target == 0) res.add(new ArrayList<>(tarSequence));
        if(candidates[idx] > target) return;

        tarSequence.add(candidates[idx]);
        traverse(candidates, target - candidates[idx] , idx, tarSequence); // Taking currentElement
        tarSequence.remove(tarSequence.size() - 1);

        traverse(candidates, target , idx + 1, tarSequence); // Not Taking currentElement

    }
}
