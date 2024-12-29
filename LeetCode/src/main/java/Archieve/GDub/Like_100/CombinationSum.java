package Archieve.GDub.Like_100;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    private List<List<Integer>> lResult = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Re Initializing Variable to Store Fresh Result
        lResult = new ArrayList<List<Integer>>();

        // Recursive Function, to fill lResult
        solve(candidates, target, 0, new ArrayList<Integer>());

        // Returning, the Filled List
        return lResult;
    }

    private void solve(int[] candidates, int target, int idx, List<Integer> l) {
        // Base case, if execution is out of range.
        if (idx >= candidates.length || target < 0) return;

        // Base case, if target is found
        if (target == 0) {
            List<Integer> cloneL = new ArrayList<>(l);
            lResult.add(cloneL);
            return;
        }

        // Iterating over two possibility - either taking current or taking same element.
        l.add(candidates[idx]);
        solve(candidates, target - candidates[idx], idx, l);
        l.remove(l.size() - 1);
        solve(candidates, target, idx + 1, l);
    }
}
