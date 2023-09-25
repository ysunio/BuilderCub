package String;

public class DifferenceString {

    public static void main(String[] args) {
        System.out.println(findTheDifference("abd", "abcd"));
        System.out.println(findTheDifferenceCheck("noy", "pony"));
    }

    static char findTheDifferenceCheck(String s, String t) {
        int[] sChar = new int[26];
        for (char x : t.toCharArray()) sChar[x - 'a']++;
        for (char x : s.toCharArray()) sChar[x - 'a']--;
        for (int idx = 0; idx < 26; idx++) if (sChar[idx] == 1) return (char) ('a' + idx);
        return 'x';
    }

    static char findTheDifference(String s, String t) {
        int valueOfXor = 0;
        for (char x : t.toCharArray()) valueOfXor ^= x;
        for (char x : s.toCharArray()) valueOfXor ^= x;
        return (char) valueOfXor;
    }
}
