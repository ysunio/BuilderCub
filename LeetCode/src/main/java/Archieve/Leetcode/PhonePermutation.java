package Archieve.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhonePermutation {

    static HashMap<Character, List<Character>> digitCombination = new HashMap<>();

    static void setPhonePermutationMap() {
        digitCombination.put('2', List.of('a', 'b', 'c'));
        digitCombination.put('3', List.of('d', 'e', 'f'));
        digitCombination.put('4', List.of('g', 'h', 'i'));
        digitCombination.put('5', List.of('j', 'k', 'l'));
        digitCombination.put('6', List.of('m', 'n', 'o'));
        digitCombination.put('7', List.of('p', 'q', 'r', 's'));
        digitCombination.put('8', List.of('t', 'u', 'v'));
        digitCombination.put('9', List.of('w', 'x', 'y', 'z'));
    }

    public static void main(String[] args) {
        setPhonePermutationMap();
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations("5432"));
    }

    static List<String> letterCombinations(String digits) {
        List<String> listResult = new ArrayList<>();
        if (digits.isEmpty()) return listResult;
        rPhone(digits, 0, new StringBuilder(), listResult);
        return listResult;
    }

    static void rPhone(String digits, int idx, StringBuilder str, List<String> listResult) {
        if (idx == digits.length()) {
            listResult.add(new String(str));
            return;
        }
        char currentChar = digits.charAt(idx);
        for (char x : digitCombination.get(currentChar)) {
            str.append(x);
            rPhone(digits, idx + 1, str, listResult);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
