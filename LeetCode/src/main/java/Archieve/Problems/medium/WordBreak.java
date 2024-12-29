package Archieve.Problems.medium;

import java.util.HashMap;
import java.util.List;

public class WordBreak {

    public static void main(String[] args) {
        System.out.println(wordBreak("aaaaaaa", List.of("aaa", "aa", "aaaaa", "aaa")));
    }

    public static boolean wordBreak(String str, List<String> wordDict) {
        return solve(str, wordDict);
    }

    static HashMap<String, Boolean> dp = new HashMap<>();

    private static boolean solve(String str, List<String> wordDict) {
        if (str.length() == 0) return false;
        if (wordDict.contains(str)) return true;

        if (dp.containsKey(str)) return dp.get(str);

        boolean found = false;
        for (int idx = 1; idx < str.length(); idx++) {
            String preString = str.substring(0, idx);
            if (wordDict.contains(preString)) {
                String remainingString = str.substring(idx);
                found |= solve(preString, wordDict) && solve(remainingString, wordDict);
                if (found) return true;
            }
        }

        dp.put(str, found);
        return found;
    }
}
