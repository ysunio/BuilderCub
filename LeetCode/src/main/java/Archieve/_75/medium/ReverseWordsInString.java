package Archieve._75.medium;

import java.util.Stack;

public class ReverseWordsInString {
    public String reverseWords(String s) {
        Stack<String> sStack = new Stack<>();

        String[] sSplit = s.trim().split(" ");
        for(String subStr : sSplit) if(!subStr.isEmpty()) sStack.push(subStr.trim());

        StringBuilder strBuilder = new StringBuilder();
        while(!sStack.isEmpty()){ strBuilder.append(sStack.pop()); strBuilder.append(" ");}

        return new String(strBuilder).trim();
    }
}
