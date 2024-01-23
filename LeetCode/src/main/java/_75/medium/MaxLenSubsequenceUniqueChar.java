package _75.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaxLenSubsequenceUniqueChar {
    public int maxLength(List<String> arr) {
        return solve(arr, 0, "");
    }

    private int solve(List<String> arr, int idx, String catString) {
        if (idx >= arr.size()) return catString.length();
        if (isUnique(arr.get(idx), catString))
            return Math.max(solve(arr, idx + 1, catString + arr.get(idx)), solve(arr, idx + 1, catString));
        return solve(arr, idx + 1, catString);
    }

    private boolean isUnique(String eA, String eB) {
        Set<Character> setCharacter = new HashSet<>();
        for (char el : eA.toCharArray()) {
            if (setCharacter.contains(el)) return false;
            setCharacter.add(el);
        }
        for (char el : eB.toCharArray()) if (setCharacter.contains(el)) return false;
        return true;
    }
}
