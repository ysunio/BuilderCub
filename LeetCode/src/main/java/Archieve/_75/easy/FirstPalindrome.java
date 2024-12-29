package Archieve._75.easy;

public class FirstPalindrome {
    public String firstPalindrome(String[] words) {
        for (String word : words) if (isPalindrome(word)) return word;
        return "";
    }

    private boolean isPalindrome(String str) {
        int len = str.length();
        for (int idx = 0; idx < (len / 2); idx++) {
            int fElement = str.charAt(idx);
            int eElement = str.charAt(len - idx - 1);
            if (fElement != eElement) return false;
        }
        return true;
    }
}
