package org.One;

public class RansomeNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] occurance = new int[26];
        for (char c : ransomNote.toCharArray()) occurance[c - 'a']++;
        for (char c : magazine.toCharArray()) occurance[c - 'a']--;
        return allMade(occurance);
    }

    private boolean allMade(int[] occurances) {
        for (int freq : occurances)
            if (freq > 0) return false;
        return true;
    }
}
