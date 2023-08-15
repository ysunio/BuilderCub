package org.One;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int len = s.length();
        int start = 0;
        int end = s.length() - 1;
        while(start < end){
            while(start < end && !(Character.isAlphabetic(s.charAt(start)) || Character.isDigit(s.charAt(start))))
                start++;
            while(end > start && !(Character.isAlphabetic(s.charAt(end)) || Character.isDigit(s.charAt(end))))
                end--;
            if(s.charAt(start) != s.charAt(end)) return false;
            start++; end--;
        }
        return true;
    }
}
