package Archieve.Problems.easy;

import java.util.Stack;

public class ValidParantheses {

    public static void main(String[] args) {
        System.out.println(isValid_Iterate("(()({}){})[]{}"));
    }

    // Great Solution -> O(N) && O(1)
    public static boolean isValid_Iterate(String s) {
        char[] charArray = s.toCharArray();
        int charIdx = 0;
        int idx = 0;
        while (idx < s.length() && charIdx >= 0) {
            char currentChar = charArray[idx];
            if (currentChar == ']')
                if (charIdx - 1 >= 0 && '[' == charArray[charIdx - 1]) charIdx--;
                else return false;
            else if (currentChar == '}')
                if (charIdx - 1 >= 0 && '{' == charArray[charIdx - 1]) charIdx--;
                else return false;
            else if (currentChar == ')')
                if (charIdx - 1 >= 0 && '(' == charArray[charIdx - 1]) charIdx--;
                else return false;
            else charArray[charIdx++] = currentChar;
            idx++;
        }
        return charIdx == 0;
    }

    public static boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : charArray) {
            switch (c) {
                case '(':
                    stack.push('(');
                    break;
                case '{':
                    stack.push('{');
                    break;
                case '[':
                    stack.push('[');
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') return false;
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') return false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') return false;
                    break;
            }
        }
        return stack.isEmpty();
    }
}
