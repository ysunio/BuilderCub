package org.One;

import java.util.Stack;

public class ValidParentheses {

    private static boolean _isValidParentheses(String pattern){
        Stack<Character> stack = new Stack<>();
        for(char c : pattern.toCharArray()){
            switch (c){
                case '{': stack.add('{'); break;
                case '[': stack.add('['); break;
                case '(': stack.add('('); break;
                case ')': if(stack.isEmpty()) return false; if(stack.pop() != '(') return false; break;
                case '}': if(stack.isEmpty()) return false; if(stack.pop() != '{') return false; break;
                case ']': if(stack.isEmpty()) return false; if(stack.pop() != '[') return false; break;
                default:
                    throw new RuntimeException("Invalid Character "+c);
            }
        }
        return stack.isEmpty();
    }

    private static boolean __isValidParentheses(String str){
        char[] charArray = str.toCharArray();
        int idx = 0;
        int itr = 0;
        while(itr < charArray.length && idx >= 0){
            if(charArray[itr] == '}'){
                if(idx >= 1 && charArray[idx - 1] == '{') idx--; else return false;
            }else if(charArray[itr] == ']') {
                if(idx >= 1 && charArray[idx - 1] == '[') idx--; else return false;
            }else if(charArray[itr] == ')') {
                if (idx >= 1 && charArray[idx - 1] == '(') idx--; else return false;
            }else
                charArray[idx++] = charArray[itr];

            itr++;
        }
        return idx == 0;
    }
}
