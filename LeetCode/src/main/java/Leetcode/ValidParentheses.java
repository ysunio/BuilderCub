package Leetcode;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("()]{}"));
        System.out.println(isValid(")[]{}"));
    }

    static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int idx = 0; idx < s.length(); idx++) {
            char sChar = s.charAt(idx);
            if (sChar == '(' || sChar == '{' || sChar == '[') stack.add(sChar);
            else {
                if (stack.isEmpty()) return false;
                char topEl = stack.pop();
                if (sChar == ')' && topEl != '(') return false;
                if (sChar == ']' && topEl != '[') return false;
                if (sChar == '}' && topEl != '{') return false;
            }
        }
        return stack.isEmpty();
    }
}
