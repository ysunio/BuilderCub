package org.code.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {

    private  static HashMap<Character, List<Character>> keypad = new HashMap<>(){{
        put('0', Arrays.asList());
        put('1', Arrays.asList());
        put('2', Arrays.asList('a','b','c'));
        put('3', Arrays.asList('d','e','f'));
        put('4', Arrays.asList('g','h','i'));
        put('5', Arrays.asList('j','k','l'));
        put('6', Arrays.asList('m','n','o'));
        put('7', Arrays.asList('p','q','r','s'));
        put('8', Arrays.asList('t','u','v'));
        put('9', Arrays.asList('w','x','y','z'));
    }};

    private static List<String> letterCombine;

    public static void main(String[] args) {
        System.out.println(letterCombinations("203641232"));
    }

    public static List<String> letterCombinations(String digits) {
        letterCombine = new ArrayList<>();
        if(digits.length() == 0) return letterCombine;
        traverse(digits, 0, new StringBuilder());
        return letterCombine;
    }

    private static void traverse(String digit, int idx, StringBuilder curKey){
        if(idx == digit.length()) {letterCombine.add(new String(curKey)); return;}
        char currentChar = digit.charAt(idx);
        if(currentChar == '0' || currentChar == '1') {
            traverse(digit, idx+1,curKey);
            return;
        }

        List<Character> keywords = keypad.get(currentChar);
        for(char word : keywords){
            curKey.append(word);
            traverse(digit, idx+1,curKey);
            curKey.deleteCharAt(curKey.length() - 1);
        }
    }
}
