package Archieve._75.easy;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        if(sChar.length > tChar.length) return false;

        int sIdx = 0;
        int tIdx = 0;

        while(sIdx < sChar.length && tIdx < tChar.length){
            while(tIdx < tChar.length && sIdx < sChar.length && tChar[tIdx] == sChar[sIdx]){ tIdx++; sIdx++; }
            tIdx++;
        }

        return sIdx == sChar.length;
    }
}
