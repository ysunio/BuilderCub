package Archieve.GDub.Like_100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhoneNumber {
    List<String> resolvedList = new ArrayList<>();
    static Map<Character, List<Character>> phoneStringMap = new HashMap<>();
    static {
        phoneStringMap.put('2', List.of('a', 'b', 'c'));
        phoneStringMap.put('3', List.of('d', 'e', 'f'));
        phoneStringMap.put('4', List.of('g', 'h', 'i'));
        phoneStringMap.put('5', List.of('j', 'k', 'l'));
        phoneStringMap.put('6', List.of('m', 'n', 'o'));
        phoneStringMap.put('7', List.of('p', 'q', 'r', 's'));
        phoneStringMap.put('8', List.of('t', 'u', 'v'));
        phoneStringMap.put('9', List.of('w', 'x', 'y', 'z'));
    }

    public List<String> letterCombinations(String digits) {
        // Base case, if we have empty digits
        if (digits.trim().isEmpty()) return new ArrayList<>();
        resolvedList = new ArrayList<>();

        // Letter combinations recursive task
        letterCombinations(digits, 0, new StringBuilder());
        return resolvedList;
    }

    private void letterCombinations(String digits, int idx, StringBuilder localString) {
        // Base case, if we are at the end of string
        if (idx >= digits.length()) {
            resolvedList.add(new String(localString));
            return;
        }

        char cChar = digits.charAt(idx);

        // Ignore 1 and 0
        if (cChar == '1' || cChar == '0') return;

        // Get over the map, for chars
        List<Character> nR = phoneStringMap.get(cChar);

        // Iterate over the list from digit.
        for (char x : nR) {

            // Adding the element in current string
            localString.append(x);

            // Continue idx + 1
            letterCombinations(digits, idx + 1, localString);
            localString.deleteCharAt(localString.length() - 1);
        }
    }
}
