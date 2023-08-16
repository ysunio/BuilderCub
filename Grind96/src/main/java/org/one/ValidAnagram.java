package org.one;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] charStore = new int[26];
        for(char c : s.toCharArray())
            charStore[c-'a']++;
        for(char c : t.toCharArray())
            charStore[c-'a']--;
        for(int c : charStore) if(c != 0) return false;
        return true;
    }
}
